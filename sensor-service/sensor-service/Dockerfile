# Imagen base con Java 17
FROM eclipse-temurin:17-jdk-alpine

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copiamos el JAR generado por Maven
COPY target/sensor-service-*.jar app.jar

# Exponemos el puerto por defecto de Spring Boot
EXPOSE 8080

# Comando de arranque
ENTRYPOINT ["java", "-jar", "app.jar"]
