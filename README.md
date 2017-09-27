# spring-cloud-zookeeper-service-discovery-demo

Tutorial using docker compose to present a hands-on session on how to use spring cloud zookeeper for service discovery.

## How is works ?

This tutorial includes two (Spring Boot) microservices called [GreetingMicroservice](spring-boot-microservice-1) and [GreetingConsumer](spring-boot-microservice-2). So, the aim of this tutorial is to demonstrate how a consumer can discover the Greeting service through [Apache Zookeeper](http://zookeeper.apache.org) and [Apache Curator Service Discovery](http://curator.apache.org/curator-x-discovery/index.html). The latter can be easily implemented in Spring Boot applications using the [Spring Cloud Zookeeper](https://cloud.spring.io/spring-cloud-zookeeper/#quick-start) API. We also used [Netflix Feign](https://github.com/OpenFeign/feign) for writing the REST consumer behavour. Finally, for this demonstration, we use a Zookeeper instance with 2 nodes (see [Docker Compose](docker-compose.yml)).

## Installation Instructions

1. Requirements

* Docker 3.2+

2. Run the following commands

```
$ git clone <REPO_GIT_URL>
$ cd spring-cloud-zookeeper-service-discovery-demo
$ docker-compose up 
```

## Checking everything works

Once the compose is deployed, make a request using the consumer microservice by accesing the following URL: [http://localhost:8180/get-greeting](http://localhost:8180/get-greeting)

## Implementation notes

### GreetingMicroservice

* [GreetingMicroservice](spring-boot-microservice-1) has the [SimpleController](spring-boot-microservice-1/src/main/java/com/ucuenca/spring/SimpleController.java) class which implements an Spring Boot application and specify the `@EnableDiscoveryClient` annotation to automatically enable the Discovery Client implementation and register the service in a zookeeper instance.
* The `spring.cloud.zookeeper.connect-string` 'spring.application.name' must be specificed in the [application.yml](spring-boot-microservice-1/src/main/resources/application.yml) file.

### GreetingConsumer

* The [ServiceConsumerClient](spring-boot-microservice-2/src/main/java/com/ucuenca/spring/ServiceConsumerClient.java) class manages the communication with the Service Discovery by implementing a REST call using a FeignClient and the service name specified in the GreetingMicroservice's `application.yml` file.
