def call(String imageName, String tag, String accountId, String region, String repo) {

    def ECR_URI = "${accountId}.dkr.ecr.${region}.amazonaws.com/${repo}"
    def REGISTRY = "${accountId}.dkr.ecr.${region}.amazonaws.com"

    sh """
    aws ecr get-login-password --region ${region} \
    | docker login --username AWS --password-stdin ${REGISTRY}

    docker tag ${imageName}:${tag} ${ECR_URI}:${tag}
    docker push ${ECR_URI}:${tag}

    docker tag ${imageName}:${tag} ${ECR_URI}:latest
    docker push ${ECR_URI}:latest

    docker rmi ${ECR_URI}:${tag} || true
    docker rmi ${ECR_URI}:latest || true
    """
}