# Imagen base con Java 17
FROM eclipse-temurin:17-jdk-alpine

# Crear directorio de trabajo
WORKDIR /app

# Copiar todo el proyecto
COPY . .

# Dar permisos a gradlew
RUN chmod +x gradlew

# Construir el proyecto
RUN ./gradlew build -x test

# Exponer el puerto dinámico de Render
EXPOSE 8080

# Comando para iniciar
CMD ["java", "-jar", "build/libs/rutasUIO-0.0.1-SNAPSHOT.jar"]