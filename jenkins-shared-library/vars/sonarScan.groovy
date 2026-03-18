def call() {
    withSonarQubeEnv('SonarQube') {
        sh """
        sonar-scanner \
        -Dsonar.projectKey=solar-system \
        -Dsonar.sources=.
        """
    }
}