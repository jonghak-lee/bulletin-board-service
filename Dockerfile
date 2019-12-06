FROM openjdk:8-jdk-alpine

ADD target/bulletin-board-service-0.0.1-SNAPSHOT.jar /app.jar

ENV PROFILES default

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", \
"-Dspring.profiles.active=${PROFILES}", "-jar", "/app.jar"]