# Use a base image that contains OpenJDK 17 (you can use any Java version you want)
FROM openjdk:17-jdk-slim
# Set the working directory inside the container
WORKDIR /app
# Copy the built JAR file from your host machine to the container
COPY target/dockerwithcomposetask-0.0.1-SNAPSHOT.jar /app/dockerwithcomposetask-0.0.1-SNAPSHOT.jar
# Expose the application port (8080 by default for Spring Boot)
EXPOSE 8080
# Set the command to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/dockerwithcomposetask-0.0.1-SNAPSHOT.jar"]