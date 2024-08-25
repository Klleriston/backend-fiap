FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/backend-0.0.1-SNAPSHOT.jar app.jar

COPY src/main/resources/fiapbackend-firebase-adminsdk-563fl-32ee904e6e.json /app/resources/fiapbackend-firebase-adminsdk-563fl-32ee904e6e.json

EXPOSE 8080

ENV SPRING_PROFILES_ACTIVE=prod
ENV FIREBASE_CONFIG_PATH=/app/resources/fiapbackend-firebase-adminsdk-563fl-32ee904e6e.json

ENTRYPOINT ["java", "-jar", "app.jar"]
