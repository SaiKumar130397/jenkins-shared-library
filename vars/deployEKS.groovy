def call(String cluster, String region, String image, String env, String releaseName, String chartPath) {

    sh """
    aws eks update-kubeconfig --region ${region} --name ${cluster}

    helm upgrade --install ${releaseName}-${env} ${chartPath} \
        --set image.repository=${image.split(':')[0]} \
        --set image.tag=${image.split(':')[1]} \
        -f ${chartPath}/values-${env}.yaml
    """
}