#
# Build del proyecto (Multi-Stage)
# --------------------------------
#
# Usamos una imagen de Gradle para hacer build de proyecto con Java
FROM gradle:8.4.0-jdk21-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/project
WORKDIR /home/gradle/project
RUN gradle build -x test

# Usamos una imagen de Openjdk
FROM openjdk:21
EXPOSE 8081
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
