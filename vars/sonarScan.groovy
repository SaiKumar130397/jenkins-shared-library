def call(String projectKey) {

    withSonarQubeEnv('sonarqube') {

        def scannerHome = tool 'sonar-scanner'

        sh """
        ${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectKey=${projectKey} \
            -Dsonar.sources=.
        """
    }
}