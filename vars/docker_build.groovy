def call(String imageName, String tag, String dockerHubUser) {
    sh """
        docker build \
            -t ${dockerHubUser}/${imageName}:${tag} \
            -t ${dockerHubUser}/${imageName}:latest \
            .
    """
    // Tags with both the specific version tag AND latest
}