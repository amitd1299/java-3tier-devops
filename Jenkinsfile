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
