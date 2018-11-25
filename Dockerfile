# TODO try JRE
FROM openjdk:8-jdk-alpine
# TODO maybe not needed
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]