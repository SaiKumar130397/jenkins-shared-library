def call(String cluster, String region, String image, String env) {

    sh """
    aws eks update-kubeconfig --region ${region} --name ${cluster}

    sed -i 's|IMAGE_PLACEHOLDER|${image}|g' k8s/${env}/deployment.yaml

    kubectl apply -f k8s/${env}/
    """
}