def call(String envPath) {

    dir(envPath) {
        sh """
        rm -rf .terraform .terraform.lock.hcl || true
        terraform init
        terraform plan
        terraform apply -auto-approve
        """
    }
}