def call(String imageName, String tag) {
    sh """
    trivy image \
        --severity HIGH,CRITICAL \
        ${imageName}:${imageTag} || true
    """
}