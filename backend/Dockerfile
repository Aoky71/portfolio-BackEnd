FROM amazoncorretto:11-alpine-jdk
MAINTAINER EstebanBelmonte
COPY target/backend-0.0.1-SNAPSHOT port-app.jar
ENTRYPOINT["Java","-jar","/port-app.jar"]
