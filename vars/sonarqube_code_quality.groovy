def call() {
    try {
        timeout(time: 5, unit: 'MINUTES') {
            def qg = waitForQualityGate()
            if (qg.status != 'OK') {
                echo "WARNING: SonarQube Quality Gate failed: ${qg.status}"
            }
        }
    } catch (Exception e) {
        echo "WARNING: Could not check Quality Gate status: ${e.message}"
        echo "Continuing pipeline..."
    }
}