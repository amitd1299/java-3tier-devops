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
    }
}
