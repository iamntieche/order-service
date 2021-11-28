pipeline {
     agent any
     environment{
         VERSION = "${env.BUILD_ID}"
     }
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
                     sh 'mvn clean package' 
                 }
             }
         }
         stage('docker build && docker push'){
             steps{ //push a image with IP nexus docker host
                script{
                    sh 'cp -r ../order-service/target .'
                    withCredentials([string(credentialsId: 'docker_pass', variable: 'docker_password')]) {
                    sh '''
                    docker build -t 192.168.16.1:8083/order-service:${VERSION} .
                    docker login -u mfoumgroup -p $docker_password 192.168.16.1:8083  
                    docker push  192.168.16.1:8083/order-service:${VERSION}
                    docker rmi   192.168.16.1:8083/order-service:${VERSION}
                   ''' 
                     }
                }
              
             }
         }
     }
}
