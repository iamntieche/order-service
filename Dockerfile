FROM adoptopenjdk/openjdk11:latest
WORKDIR /work
COPY . .
COPY /target/order-service-3.0.0-SNAPSHOT.jar order-service.jar
ENTRYPOINT ["java", "-jar", "order-service.jar"]

