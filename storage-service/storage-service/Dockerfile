FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/storage-service-*.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]
