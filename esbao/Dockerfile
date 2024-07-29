# Utiliza la imagen base de OpenJDK 17
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Argumento para el archivo JAR
ARG JAR_FILE=build/libs/prefectura_esbao-0.0.1-SNAPSHOT.jar

# Copia el archivo JAR en el contenedor
COPY ${JAR_FILE} app_esbao.jar

# Expone el puerto 8080 para el servicio
EXPOSE 8080

# Establecer las variables de entorno necesarias para Spring Boot
ENV DB_URL=jdbc:postgresql://dpg-cqk125eehbks73ck503g-a.oregon-postgres.render.com:5432/esbao_db
ENV DB_USER_NAME=esbao_db_user
ENV DB_PASSWORD=KXdHsokGbqQK5fGdvYurj1s4b5hdekC2
ENV DB_JWT_PRIVATE=jwtKeys/private.key.pem
ENV DB_JWT_PUBLIC=jwtKeys/public.key.pem

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app_esbao.jar"]
