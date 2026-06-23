def call() {
    timeout(time: 1, unit: 'HOURS') {
        def qg = waitForQualityGate()
        if (qg.status != 'OK') {
            // Change to 'error(...)' if you want pipeline to hard-fail
            echo "WARNING: SonarQube Quality Gate failed: ${qg.status}"
            // error "Pipeline failed due to Quality Gate: ${qg.status}"
        }
    }
}