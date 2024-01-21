# Spring Boot Microservice with Docker Compose and Kubernetes

![image](https://img.shields.io/badge/java-323330?style=for-the-badge&logo=java&logoColor=FF0000)
![image](https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![image](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![image](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![image](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![image](https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white)
![image](https://img.shields.io/badge/kubernetes-326ce5.svg?&style=for-the-badge&logo=kubernetes&logoColor=white)
![image](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![image](https://img.shields.io/badge/rabbitmq-%23FF6600.svg?&style=for-the-badge&logo=rabbitmq&logoColor=white)


## Overview

This repository contains a Comprehensive guide to build the microservices using Spring boot Cloud modules, dockerize the services and run using docker Compose and as well as deployment on the kubernetes cluster.

## Microservices
- Eureka Server ( Service Discovery server to monitor the services )
- API Gateway ( To expose the certain url to thr outside system )
- Customer ( to register the customer )
- Fraud ( check if the customer is a fraudster )
- Notification ( for sending notification to the external source)
- Zipkin ( Distributed Tracing System to trace the entire request lifecycle )
- PostgreSql ( Relational DB use to save customer, fraudster log and notification )
- RabbitMQ ( A message queue system to decouple the microservices dependencies for asynchrounus processing )


## Features

- **Spring Boot Microservice:** A simple yet powerful microservice built using the Spring Boot framework.
- **Docker Compose:** Compose simplifies the control of your entire application stack, making it easy to manage services, networks, and volumes in a single, comprehensible YAML
- **Kubernetes Deployment:** Scalable deployment for production environments.

## Running the application on Docker
![project-overview](https://github.com/saif-15/Microservices/assets/46129194/2e4edcfb-52e0-4dcd-99e8-a11ffa6c67f0)

## Prerequisites

- Docker
- Docker Compose
- Java Development Kit (JDK)
- Maven

### Local Development with Docker Compose

1. Clone the repository:

   ```bash
   git clone https://github.com/saif-15/Microservices.git

2. Go Into Directory:

   ```bash
   cd Microservices

3. Run With Docker Compose:

   ```bash
    docker compose up -d
   
4. Verify the Application
   
  - Pgadmin Ui = http://localhost:5050/  ( configure postgres running on 5432)
  - Eureka Server = http://localhost:8761/
  - RabbitMQ = http://localhost:15672/ (guest,guest)
  - Zipkin = http://localhost:9411/zipkin/
  - Customer = http://localhost:8083/api/v1/customers (POST)
  -      {
           "firstName": "saif",
           "lastName": "ulhaq",
           "email": "saif@email.com"
         }
   

## Running the application on Kubernetes cluster

![k8s](https://github.com/saif-15/Microservices/assets/46129194/8cba6004-000e-4902-9d4d-d229fbe3272b)

## Prerequisites

- Kubernetes Local Cluster (Minikube,kind)
- kubectl utility

### Local Deployment on K8s Cluster

1. Start the cluster:

   ```bash
   minikube start

2. Go Into Directory:

   ```bash
   cd Microservices

3. Apply The yaml Manifest resources:

   ```bash
   kubectl apply -f ./kubernetes/minikube/bootstrap/postgres/
   kubectl apply -f ./kubernetes/minikube/bootstrap/zipkin/
   kubectl apply -f ./kubernetes/minikube/bootstrap/rabbitmq/
   kubectl apply -f ./kubernetes/minikube/services/customer/
   kubectl apply -f ./kubernetes/minikube/services/notification/
   kubectl apply -f ./kubernetes/minikube/services/fraud/
   kubectl apply -f ./kubernetes/minikube/ingress/
   
4. Verify the Pods:

   ```bash
   kubectl get pods
  ![pods](https://github.com/saif-15/Microservices/assets/46129194/86551c93-9190-42dd-be6e-59dc85502b97)

5. Verify the Services:

   ```bash
   kubectl get svc
  ![services](https://github.com/saif-15/Microservices/assets/46129194/c33b32e8-edac-41e1-b99d-463b69e69d2e)

6. Verify the Ingress:

   ```bash
   kubectl get ingress
![ingress](https://github.com/saif-15/Microservices/assets/46129194/70841dc6-4341-4f1a-ae87-1c35ba41e4bf)

7. Minikube Specific Config

   ```bash
   minikube tunnel
   
To expose the application outside minikube cluster



   
