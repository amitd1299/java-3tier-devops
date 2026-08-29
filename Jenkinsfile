pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                dir('backend') {
                    bat '.\mvnw.cmd clean package -DskipTests'
                }
            }
        }

        stage('Test') {
            steps {
                dir('backend') {
                    bat '.\mvnw.cmd test'
                }
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t java-3tier-backend:1.0 backend'
            }
        }
    }
}
