# Imagen base oficial con Java 17
FROM eclipse-temurin:17-jdk-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el JAR generado por Maven al contenedor
COPY target/collector-service-*.jar app.jar

# Expone el puerto en el que corre Spring Boot
EXPOSE 8081

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]