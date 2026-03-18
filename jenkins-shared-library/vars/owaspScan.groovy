def call() {
    sh 'mkdir -p reports'

    withCredentials([string(credentialsId: 'nvd-api-key', variable: 'NVD_API_KEY')]) {
        dependencyCheck additionalArguments: """
            --project solar-system
            --scan .
            --format XML
            --format HTML
            --out reports
            --failOnCVSS 8
            --nvdApiKey ${NVD_API_KEY}
        """,
        odcInstallation: 'dependency-check'
    }

    dependencyCheckPublisher pattern: 'reports/dependency-check-report.xml'
}