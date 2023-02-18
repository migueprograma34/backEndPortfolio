FROM amazoncorretto:11-alpine-jdk
MAINTAINER migue
COPY target/migue-0.0.1-SNAPSHOT.jar  migue-app.jar
ENTRYPOINT ["java","-jar","/migue-app.jar"]