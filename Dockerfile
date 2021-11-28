FROM tomcat 
WORKDIR webapps 
COPY target/order-service-0.0.1-SNAPSHOT.jar  .
RUN rm -rf ROOT && mv order-service-0.0.1-SNAPSHOT.jar  ROOT.jar
ENTRYPOINT ["sh", "/usr/local/tomcat/bin/startup.sh"]