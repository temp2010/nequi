FROM openjdk:21-slim
WORKDIR /app
COPY target/franchise-api-1.1.jar /app.jar
EXPOSE 8080

ENV DB_HOST=postgres
ENV DB_PORT=5432
ENV DB_NAME=franchise
ENV DB_USERNAME=franchise

ENTRYPOINT ["java", "-jar", "/app.jar"]