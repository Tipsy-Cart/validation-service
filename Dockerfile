FROM openjdk:17
COPY validation-service-0.0.1-SNAPSHOT.jar /validation-service.jar
CMD ["java", "-jar", "-noverify","/validation-service.jar"]
EXPOSE 8080