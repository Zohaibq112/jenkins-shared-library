def call(String url, String branch) {
    checkout([
        $class: 'GitSCM',
        branches: [[name: "*/${branch}"]],
        extensions: [[
            $class: 'CloneOption',
            shallow: true,
            depth: 1,
            timeout: 30
        ]],
        userRemoteConfigs: [[
            url: url,
            credentialsId: 'Github-cred'
        ]]
    ])
}