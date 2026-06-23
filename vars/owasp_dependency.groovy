def call() {
    dependencyCheck(
        additionalArguments: '''
            --scan ./
            --format XML
            --out ./
            --prettyPrint
        ''',
        odcInstallation: 'DC'
        // 'DC' must match the name you gave OWASP DC in
        // Manage Jenkins → Global Tool Configuration
    )

    dependencyCheckPublisher(
        pattern: '**/dependency-check-report.xml'
    )
}