FROM adoptopenjdk/openjdk11:latest
WORKDIR /work
COPY . /work/
COPY /work/target/order-service-0.0.1-SNAPSHOT.jar /work/order-service.jar
ENTRYPOINT ["java", "-jar", "/work/order-service.jar"]
