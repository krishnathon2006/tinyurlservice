FROM openjdk:21-slim

ARG JAR_FILE=build/libs/tinyurl*.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
