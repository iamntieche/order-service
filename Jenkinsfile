pipeline{
    agent any
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