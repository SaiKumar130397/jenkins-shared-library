def call(String imageName, String tag) {
    sh """
    trivy image ${imageName}:${tag} || true
    """
}