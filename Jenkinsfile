pipeline {
    agent any

    tools {
        jdk 'JDK-21'
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
                sh 'docker build -t java-3tier-backend:1.0 backend'
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
                        echo "$NEXUS_PASSWORD" | docker login localhost:8082 \
                            -u "$NEXUS_USER" \
                            --password-stdin

                        docker tag java-3tier-backend:1.0 \
                            localhost:8082/java-3tier-backend:1.0

                        docker push localhost:8082/java-3tier-backend:1.0

                        docker logout localhost:8082
                    '''
                }
            }
        }
    }
}