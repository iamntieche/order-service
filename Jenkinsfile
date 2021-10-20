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
         }
         stage('Upload Jar To Nexus'){
             steps{
                     nexusArtifactUploader artifacts: [
                         [
                             artifactId: 'order-service', 
                             classifier: '', 
                             file: 'target/order-service-1.0.0.jar',
                             type: 'jar'
                        ]
                    ], 
                    credentialsId: 'nexus3', 
                    groupId: 'com.mfoumgroup', 
                    nexusUrl: 'localhost:8081', 
                    nexusVersion: 'nexus3', 
                    protocol: 'http', 
                    repository: 'order-service-release', 
                    version: '1.0.0'
             }

         }
     }
}