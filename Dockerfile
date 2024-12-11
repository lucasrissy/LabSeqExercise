FROM openjdk:17-jdk-alpine

LABEL authors="lucasrissi"

# Set the working directory
WORKDIR /app

COPY target/AlticeLabsExercise-0.0.1-SNAPSHOT.jar /app/AlticeLabsExercise-0.0.1-SNAPSHOT.jar

# Expose the port the app runs on
EXPOSE 8080

ENTRYPOINT ["java","-jar","AlticeLabsExercise-0.0.1-SNAPSHOT.jar"]