pipeline {
     agent any
     tools { //permet d'activer le patch maven
        maven 'maven3'
     }
     stages{
         stage('sonar quality Gate'){
             steps{
                 script{
                     withSonarQubeEnv(credentialsId: 'sonarqube-token') {
                         sh 'mvn sonar:sonar'
                        }
                 }
             }
         }
         stage('Build'){
             steps{
                 sh 'mvn clean package' //exécution de cette commande grâce au shell
             }
         }
     }
}
