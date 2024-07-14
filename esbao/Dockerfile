FROM openjdk:17-jdk-slim
ARG JAR_FILE=build/libs/prefectura_esbao-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_esbao.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_esbao.jar"]