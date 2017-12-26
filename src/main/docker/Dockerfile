FROM openjdk:8-jdk-alpine
MAINTAINER gaozhiwen <gaulzhw@gmail.com>

EXPOSE 8080
COPY mykingdom-imking.jar /app/mykingdom-imking.jar

ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app/mykingdom-imking.jar" ]
