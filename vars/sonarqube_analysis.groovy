def call(String sonarTool, String projectName, String projectKey) {
    try {
        withSonarQubeEnv(sonarTool) {
            sh """
                \$SONAR_HOME/bin/sonar-scanner \
                    -Dsonar.projectName=${projectName} \
                    -Dsonar.projectKey=${projectKey} \
                    -Dsonar.organization=zohaibq112 \
                    -Dsonar.host.url=https://sonarcloud.io \
                    -Dsonar.sources=. \
                    -Dsonar.java.binaries=. \
                    -Dsonar.scanner.skipJreProvisioning=true
            """
        }
    } catch (Exception e) {
        echo "WARNING: SonarQube analysis failed: ${e.message}"
        echo "Continuing pipeline..."
    }
}