FROM openjdk:11-jdk

WORKDIR /app

COPY . .

RUN apt-get update && \
    apt-get install -y gradle && \
    gradle clean build --no-daemon

EXPOSE 8080

CMD ["java", "-jar", "build/libs/your-app-1.0-SNAPSHOT.jar"]