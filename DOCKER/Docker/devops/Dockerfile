FROM openjdk:8-jre-alpine

USER root

ADD ./Docker/target/hellomaven-1.0-SNAPSHOT.jar /opt/hellomaven-1.0-SNAPSHOT.jar
CMD ["java", "-Xmx200m", "-jar", "/opt/hellomaven-1.0-SNAPSHOT.jar"]

EXPOSE 8080
