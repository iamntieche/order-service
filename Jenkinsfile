pipeline{
    agent any
    stages{
        stage("sonar quality check"){
            agent {
                docker {
                    image 'maven'
                    args '-v $HOME/.m2:/root/.m2'
                }
            }

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