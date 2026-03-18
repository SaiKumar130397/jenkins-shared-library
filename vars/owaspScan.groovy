def call() {

    sh 'mkdir -p reports'

    def dcHome = tool 'dependency-check'

    withCredentials([string(credentialsId: 'nvd-api-key', variable: 'NVD_API_KEY')]) {

        sh """
        ${dcHome}/bin/dependency-check.sh \
            --project solar-system \
            --scan . \
            --format XML \
            --format HTML \
            --out reports \
            --failOnCVSS 8 \
            --nvdApiKey $NVD_API_KEY
        """
    }

    dependencyCheckPublisher pattern: 'reports/dependency-check-report.xml'
}