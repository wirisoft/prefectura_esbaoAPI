# Utiliza la imagen base de OpenJDK 17
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

ARG JAR_FILE=esbao/build/libs/prefectura_esbao-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_esbao.jar


# Expone el puerto 8080 para el servicio
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app_esbao.jar"]
