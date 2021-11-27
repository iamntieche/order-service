pipeline{
    agent any
    tools { //permet d'activer le patch maven
        maven 'maven3'
     }
    stages{
        stage("sonar quality check"){
            steps{
                script{
                    withSonarQubeEnv(credentialsId: 'sonar-pwd') 
                    {
                       sh "mvn sonar:sonar"
                    }
                }
            }
        }
    }
}