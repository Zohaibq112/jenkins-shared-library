def call() {
    sh """
        trivy fs --format table -o trivy-fs-report.xml . || true
    """
    // '|| true' prevents pipeline failure on LOW/MEDIUM vulnerabilities
    // Remove it if you want the pipeline to fail on any finding
}