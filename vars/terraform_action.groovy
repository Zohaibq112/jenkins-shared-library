def call(String action) {
    // action should be "apply" or "destroy"
    withCredentials([[$class: 'AmazonWebServicesCredentialsBinding',
                      credentialsId: 'AWS-cred',
                      accessKeyVariable: 'AWS_ACCESS_KEY_ID',
                      secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) {
        sh """
            export AWS_ACCESS_KEY_ID=\$AWS_ACCESS_KEY_ID
            export AWS_SECRET_ACCESS_KEY=\$AWS_SECRET_ACCESS_KEY

            echo "Running terraform ${action}..."

            terraform init -reconfigure

            terraform validate

            terraform plan -out=tfplan

            terraform ${action} -auto-approve tfplan
        """
    }
}