FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} notifications-fintech.jar
ENTRYPOINT ["java","-jar","/notifications-fintech.jar"]
