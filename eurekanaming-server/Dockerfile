FROM openjdk:17
EXPOSE 8761
ADD target/eureka-service.jar eureka-service.jar
ENTRYPOINT ["java","-jar","/eureka-service.jar"]