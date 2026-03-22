def call() {
    env.AWS_REGION = sh(script: 'aws configure get region || echo ap-southeast-2', returnStdout: true).trim()
    env.AWS_ACCOUNT_ID = sh(script: 'aws sts get-caller-identity --query Account --output text', returnStdout: true).trim()
}
