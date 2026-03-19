// vars/terraformApply.groovy
def call(String envPath) {

    dir(envPath) {
        sh """
        terraform init
        terraform plan
        terraform apply -auto-approve
        """
    }
}