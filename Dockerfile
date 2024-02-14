FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/SEMANA9-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} huaycosos.jar
ENTRYPOINT ["java","-jar","/huaycosos.jar"]