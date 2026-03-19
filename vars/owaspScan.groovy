def call() {

    def dcHome = tool 'dependency-check'

    sh 'mkdir -p reports'
    sh 'mkdir -p /var/lib/jenkins/odc-data'

    withCredentials([string(credentialsId: 'nvd-api-key', variable: 'NVD_API_KEY')]) {

        def status = sh(
            script: """
            ${dcHome}/bin/dependency-check.sh \
                --project solar-system \
                --scan . \
                --format XML \
                --format HTML \
                --out reports \
                --data /var/lib/jenkins/odc-data \
                --nvdApiKey $NVD_API_KEY \
                --nvdApiDelay 2000 \
                --noupdate \
                --disableYarnAudit \
                --disableOssIndex
            """,
            returnStatus: true
        )

        echo "OWASP scan exit code: ${status}"
    }

    dependencyCheckPublisher pattern: 'reports/dependency-check-report.xml'
}