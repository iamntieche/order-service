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
                 script{
                     def mavenPom = readMavenPom file: 'pom.xml' //permet de lire le fichier pom.xml
                     def nexusRepoName = mavenPom.version.endsWith("SNAPSHOT") ? "order-service-snapshot" : "order-service-release"
                     nexusArtifactUploader artifacts: [
                         [
                             artifactId: 'order-service', 
                             classifier: '', 
                             file: "target/order-service-${mavenPom.version}.jar",
                             type: 'jar'
                        ]
                    ], 
                    credentialsId: 'nexus3', 
                    groupId: 'mfoumgroup', 
                    nexusUrl: 'localhost:8081', 
                    nexusVersion: 'nexus3', 
                    protocol: 'http', 
                    repository: nexusRepoName, 
                    version: "${mavenPom.version}"
                 }
             }

         }
     }
}
