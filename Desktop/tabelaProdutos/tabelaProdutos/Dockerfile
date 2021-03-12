FROM openjdk:11-jdk
MAINTAINER Felipe Natividade
WORKDIR /app
COPY target/tabelaProdutos-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]