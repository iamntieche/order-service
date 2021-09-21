pipeline {
     agent any
     tools { //permet d'activer le patch maven
        maven 'maven3'
     }
     stages{
         stage('Build'){
             steps{
                 sh 'mvn clean package' //exécution de cette commande grâce au shell
             }
             nexusArtifactUploader artifacts: [[artifactId: 'order-service', classifier: '', file: 'target/order-service-0.0.1.jar', type: 'jar']], credentialsId: 'nexus3', groupId: 'com.mfoumgroup', nexusUrl: 'localhost', nexusVersion: 'nexus3', protocol: 'http', repository: 'http://localhost:8081/repository/order-service-release/', version: '0.0.1'
         }
         stage('Upload Jar To Nexus'){
             steps{
                     nexusArtifactUploader artifacts: [
                         [
                             artifactId: 'order-service', 
                             classifier: '', 
                             file: 'target/order-service-0.0.1.jar',
                             type: 'jar'
                        ]
                    ], 
                    credentialsId: 'nexus3', 
                    groupId: 'com.mfoumgroup', 
                    nexusUrl: 'localhost:8081', 
                    nexusVersion: 'nexus3', 
                    protocol: 'http', 
                    repository: 'http://localhost:8081/repository/order-service-release/', 
                    version: '0.0.1'
             }

         }
     }
}