def call() {
    try {
        timeout(time: 10, unit: 'MINUTES') {
            dependencyCheck(
                additionalArguments: '--scan ./ --format XML --out ./ --prettyPrint',
                odcInstallation: 'DC'
            )
            dependencyCheckPublisher(
                pattern: '**/dependency-check-report.xml'
            )
        }
    } catch(Exception e) {
        echo "OWASP check timed out or failed: ${e.message}"
        echo "Continuing pipeline..."
    }
}