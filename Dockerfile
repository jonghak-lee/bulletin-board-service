FROM openjdk:8-jdk-alpine

ADD target/bulletin-board-service-0.0.1-SNAPSHOT.jar /app.jar

ENV PROFILES default
ENV USER_SERVICE_URL http://localhost:8081

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", \
"-Dspring.profiles.active=${PROFILES}", \
"-Dfeign.client.config.user-service.url=${USER_SERVICE_URL}", \
"-jar", "/app.jar"]