def call() {
    sh """
        if command -v trivy &> /dev/null; then
            trivy fs --format table -o trivy-fs-report.xml . || true
        else
            echo "Trivy not installed, skipping scan"
        fi
    """
}