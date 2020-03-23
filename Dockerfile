FROM openjdk:11-jre-slim

ARG JAR

WORKDIR /clines

COPY ${JAR} /clines/app.jar

ENV JVM_OPTS ''

CMD java $JVM_OPTS -jar app.jar