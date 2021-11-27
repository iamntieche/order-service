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
                    withSonarQubeEnv(credentialsId: 'sonarqube-password') 
                    {
                       sh "mvn sonar:sonar -Dsonar.login=25260e63bfb975694e98bba03fb4c3c5c7441b51"
                    }
                }
            }
        }
    }
}