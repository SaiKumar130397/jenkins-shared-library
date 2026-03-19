def call() {

    withSonarQubeEnv('sonarqube') {

        def scannerHome = tool 'sonar-scanner'

        sh """
        ${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectKey=solar-system \
            -Dsonar.sources=.
        """
    }
}