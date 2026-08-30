pipeline {
    agent any

    tools {
        jdk 'JDK-21'
    }

    environment {
        IMAGE_NAME = 'java-3tier-backend'
        NEXUS_REGISTRY = '172.31.11.48:8082'
        IMAGE_TAG = "${BUILD_NUMBER}"
        FULL_IMAGE = "${NEXUS_REGISTRY}/${IMAGE_NAME}:${BUILD_NUMBER}"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                dir('backend') {
                    sh './mvnw clean package -DskipTests'
                }
            }
        }

        stage('Test') {
            steps {
                dir('backend') {
                    sh './mvnw test'
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                dir('backend') {
                    withSonarQubeEnv('SonarQube') {
                        sh './mvnw sonar:sonar'
                    }
                }
            }
        }

        stage('Docker Build') {
            steps {
                sh '''
                    docker build \
                        -t ${IMAGE_NAME}:${IMAGE_TAG} \
                        backend
                '''
            }
        }

        stage('Nexus Docker Push') {
            steps {
                withCredentials([
                    usernamePassword(
                        credentialsId: 'nexus-docker',
                        usernameVariable: 'NEXUS_USER',
                        passwordVariable: 'NEXUS_PASSWORD'
                    )
                ]) {
                    sh '''
                        echo "$NEXUS_PASSWORD" | docker login ${NEXUS_REGISTRY} \
                            -u "$NEXUS_USER" \
                            --password-stdin

                        docker tag ${IMAGE_NAME}:${IMAGE_TAG} \
                            ${FULL_IMAGE}

                        docker push ${FULL_IMAGE}

                        docker logout ${NEXUS_REGISTRY}
                    '''
                }
            }
        }

        stage('Kubernetes Deploy') {
            steps {
                sh '''
                    kubectl set image deployment/java-3tier-backend \
                        java-3tier-backend=${FULL_IMAGE}

                    kubectl rollout status deployment/java-3tier-backend \
                        --timeout=180s
                '''
            }
        }

        stage('Verify Backend') {
            steps {
                sh '''
                    kubectl get deployment java-3tier-backend
                    kubectl get pods -l app=java-3tier-backend
                    kubectl get svc java-3tier-backend
                    kubectl get endpoints java-3tier-backend
                '''
            }
        }
    }
}
