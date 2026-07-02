def call() {
    dependencyCheck(
        additionalArguments: '--scan ./ --format XML --out ./ --prettyPrint',
        odcInstallation: 'DC'
    )
    dependencyCheckPublisher(
        pattern: '**/dependency-check-report.xml'
    )
}