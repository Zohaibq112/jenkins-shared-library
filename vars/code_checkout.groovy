def call(String url, String branch) {
    retry(3) {
        checkout([
            $class: 'GitSCM',
            branches: [[name: "*/${branch}"]],
            extensions: [
                [$class: 'CloneOption', shallow: true, depth: 1, noTags: true, timeout: 30],
                [$class: 'WipeWorkspace']
            ],
            userRemoteConfigs: [[url: url, credentialsId: 'Github-cred']]
        ])
    }
}