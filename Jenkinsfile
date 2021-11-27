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
                       
                    timeout(time: 1, unit: 'HOURS') {
                      def qg = waitForQualityGate()
                      if (qg.status != 'OK') {
                           error "Pipeline aborted due to quality gate failure: ${qg.status}"
                      }
                    } 
                    //build project
                    sh 'mvn clean package'
                 }
             }
         }
     }
}
