def call() {
    try {
        timeout(time: 2, unit: 'MINUTES') {
            def qg = waitForQualityGate()
            if (qg.status != 'OK') {
                echo "WARNING: Quality Gate status: ${qg.status}"
            } else {
                echo "Quality Gate passed!"
            }
        }
    } catch (Exception e) {
        echo "WARNING: Quality Gate check failed: ${e.message}"
        echo "Continuing pipeline anyway..."
    }
}