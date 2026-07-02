def call() {
    sh """
        if command -v trivy > /dev/null 2>&1; then
            trivy fs --timeout 10m --format table -o trivy-fs-report.xml . || true
        else
            echo "Trivy not installed, skipping scan"
        fi
    """
}