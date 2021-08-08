FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/jspr-boot-rest-0.0.1-SNAPSHOT.jar jsprbootrestapp.jar
ENTRYPOINT ["java", "-jar", "jsprbootrestapp.jar"]