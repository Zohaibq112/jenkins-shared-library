def call() {
    dependencyCheck(
        additionalArguments: '--scan ./ --format XML --out ./ --prettyPrint',
        odcInstallation: 'DC'    ← must match exactly
    )
    dependencyCheckPublisher(
        pattern: '**/dependency-check-report.xml'
    )
}