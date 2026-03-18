def call(String imageName, String tag, String accountId, String region, String repo) {

    def ECR_URI = "${accountId}.dkr.ecr.${region}.amazonaws.com/${repo}"

    sh """
    aws ecr get-login-password --region ${region} \
    | docker login --username AWS --password-stdin ${accountId}.dkr.ecr.${region}.amazonaws.com

    docker tag ${imageName}:${tag} ${ECR_URI}:${tag}
    docker push ${ECR_URI}:${tag}

    docker tag ${imageName}:${tag} ${ECR_URI}:latest
    docker push ${ECR_URI}:latest
    """
}