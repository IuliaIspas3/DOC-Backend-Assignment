FROM maven:3.9.6-amazoncorretto-17-debian AS build
RUN mkdir -p /app
WORKDIR /app
COPY pom.xml /app
COPY src /app/src
RUN mvn -B package --file pom.xml -DskipTests


# Fetch Java
FROM openjdk:17
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar
# Expose port 8080
EXPOSE 8080
CMD java -jar app.jar