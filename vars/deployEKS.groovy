def call(String cluster, String region, String image, String env) {

    sh """
    aws eks update-kubeconfig --region ${region} --name ${cluster}

    helm upgrade --install solar-${env} ./helm/solar-system \
        --set image.repository=${image.split(':')[0]} \
        --set image.tag=${image.split(':')[1]} \
        -f helm/solar-system/values-${env}.yaml
    """
}