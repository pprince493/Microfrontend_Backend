FROM openjdk:8

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY /target/*.jar app.jar

# Expose any necessary ports (if required by your application)
EXPOSE 9097

# Specify the command to run your application
CMD ["java", "-jar", "app.jar"]