# Fetch Java
FROM openjdk:17
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar
# Expose port 8080
EXPOSE 8080
CMD java -jar app.jar