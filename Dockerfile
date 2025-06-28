FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY . .

RUN chmod +x ./gradlew && ./gradlew clean bootJar -x test

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java -jar build/libs/*SNAPSHOT.jar --spring.profiles.active=local"]
