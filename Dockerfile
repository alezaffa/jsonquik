FROM openjdk:8
ADD target/jsonquik.jar jsonquik.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "jsonquik.jar"]