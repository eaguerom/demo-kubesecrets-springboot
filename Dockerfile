FROM openjdk:8-jre-alpine

RUN apk update && apk upgrade

ENV TZ=America/Costa_Rica

EXPOSE 8080/tcp

RUN mkdir -p /home/ms/demo

WORKDIR /home/ms/demo

ADD target/demo.jar demo.jar

CMD java -jar -XX:+UseG1GC demo.jar

# DEFAULT HEALTHCKECK: interval 30s, timeout 30s, start-period 0s, and retries 3
# HEALTHCHECK CMD curl --fail http://localhost:8080/pppmodule/v2/actuator/health || exit 1
HEALTHCHECK CMD curl --fail http://localhost:8080/playground/test/ping || exit 1