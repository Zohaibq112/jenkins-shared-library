def call(String action) {
    withCredentials([
        [$class: 'AmazonWebServicesCredentialsBinding',
         credentialsId: 'AWS-cred',
         accessKeyVariable: 'AWS_ACCESS_KEY_ID',
         secretKeyVariable: 'AWS_SECRET_ACCESS_KEY'],
        string(credentialsId: 'SSH-PUBLIC-KEY', variable: 'TF_VAR_public_key')
        // TF_VAR_ prefix automatically passes it as terraform variable
    ]) {
        sh """
            export AWS_ACCESS_KEY_ID=\$AWS_ACCESS_KEY_ID
            export AWS_SECRET_ACCESS_KEY=\$AWS_SECRET_ACCESS_KEY
            export TF_VAR_public_key="\$TF_VAR_public_key"

            echo "Running terraform ${action}..."
            terraform init -reconfigure
            terraform validate
            terraform plan -out=tfplan
            terraform ${action} -auto-approve tfplan
        """
    }
}