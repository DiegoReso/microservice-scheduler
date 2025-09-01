FROM amazoncorretto:21
WORKDIR /app
COPY build/libs/scheduler-0.0.1-SNAPSHOT.jar /app/scheduler.jar
EXPOSE 8081
CMD ["java", "-jar", "/app/scheduler.jar"]