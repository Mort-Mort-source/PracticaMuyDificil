FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/alert-service-*.jar app.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "app.jar"]