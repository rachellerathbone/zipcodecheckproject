pipeline {
    agent any
    
    stages {
        stage("build") {
            steps {
                echo 'predicting the future...'
            }
            post {
                 always {
                     jiraSendBuildInfo site: 'nsurendran1991.atlassian.net'
                 }
             }
        }
        
        stage("deploy") {
            steps {
                echo 'deploying...'
            }
            post {
                always {
                    jiraSendDeploymentInfo site: 'nsurendran1991.atlassian.net', enableGating: false, environmentId: 'jenkins-testing-prod-1', environmentName: 'jenkins-testing-prod-1', environmentType: 'prod'
                }
            }
        }
    }
}
