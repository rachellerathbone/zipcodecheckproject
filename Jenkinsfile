pipeline {
    agent any
    
    tools {
        maven 'maven'
       
    }
    
    stages {
        stage("build") {
            steps {
                sh 'mvn clean install'
            }
            post {
                 always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                     jiraSendBuildInfo site: 'rachellerathbone.atlassian.net'
                 }
             }
        }
        
        stage("deploy") {
            steps {
                echo 'deploying...'
            }
            post {
                always {
                    jiraSendDeploymentInfo site: 'rachellerathbone.atlassian.net', enableGating: false, environmentId: 'jenkins-testing-prod-1', environmentName: 'staging', environmentType: 'staging'
                }
            }
        }
    }
}
