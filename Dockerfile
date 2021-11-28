FROM adoptopenjdk/openjdk11:latest
WORKDIR /work
COPY . .
COPY target/order-service-0.0.1-SNAPSHOT.jar order-service.jar
ENTRYPOINT ["java", "-jar", "order-service.jar"]
