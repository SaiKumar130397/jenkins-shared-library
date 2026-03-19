def call(String imageName, String tag) {
    sh """
    trivy image \
        --severity HIGH,CRITICAL \
        --format table \
        ${imageName}:${tag} || true
    """
}