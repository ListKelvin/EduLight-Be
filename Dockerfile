FROM openjdk:17-alpine
WORKDIR /app
COPY ./out/artifacts/EduLight_jar .
EXPOSE 8080
CMD ["java", "-jar", "EduLight.jar"]