from maven:3.5.0-jdk-8-alpine

MAINTAINER Santiago Gonzalez, <hernangt12re3@gmail.com>

ENV APP_DIR=/spring-boot-app

EXPOSE 8080

RUN apk update && apk upgrade && \
    apk add --no-cache bash git openssh

# App configuration
WORKDIR ${APP_DIR}
RUN mkdir -p ${APP_DIR}
# RUN git clone

COPY * ${APP_DIR}/
COPY src ${APP_DIR}/src

RUN mvn clean package

ENTRYPOINT ["java"]
CMD ["-jar", "target/spring-boot-microservice-2-1.0-SNAPSHOT.jar"]
