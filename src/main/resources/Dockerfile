FROM maven:3.8.3-openjdk-8 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

FROM amazoncorretto:8-alpine3.17-jre
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
COPY opentelemetry-javaagent.jar ./opentelemetry-javaagent.jar
#COPY opentelemetry-javaagent-all.jar ./opentelemetry-javaagent-all.jar
EXPOSE 8080

ENTRYPOINT ["java", "-Dserver.port=8080", "-javaagent:opentelemetry-javaagent.jar, "-jar", "app.jar"]
