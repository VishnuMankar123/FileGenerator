FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/FileGenerator-0.0.1-SNAPSHOT.jar FileGenerator.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/FileGenerator.jar"]