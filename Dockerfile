FROM maven:3.6.3-jdk-13 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml package

#Package App change
FROM openjdk:13-alpine
COPY --from=build /usr/src/app/target/healthcare-0.0.1-SNAPSHOT.jar /usr/app/healthcare-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/usr/app/healthcare-0.0.1-SNAPSHOT.jar"]
