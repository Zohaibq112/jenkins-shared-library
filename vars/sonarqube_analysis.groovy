def call(String sonarTool, String projectName, String projectKey) {
    withSonarQubeEnv(sonarTool) {
        // SONAR_HOME is set in the Jenkinsfile via:
        // environment { SONAR_HOME = tool "Sonar" }
        sh """
            \$SONAR_HOME/bin/sonar-scanner \
                -Dsonar.projectName=${projectName} \
                -Dsonar.projectKey=${projectKey} \
                -Dsonar.sources=. \
                -Dsonar.java.binaries=.
        """
    }
}