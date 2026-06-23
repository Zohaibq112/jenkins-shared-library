def call(String imageName, String tag, String dockerHubUser) {
    withCredentials([usernamePassword(
        credentialsId: 'DockerHub-cred',
        usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS'
    )]) {
        sh """
            echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin

            docker push ${dockerHubUser}/${imageName}:${tag}
            docker push ${dockerHubUser}/${imageName}:latest

            # Clean up local images to save disk space on agent
            docker rmi ${dockerHubUser}/${imageName}:${tag} || true
            docker rmi ${dockerHubUser}/${imageName}:latest || true
        """
    }
}