# Spring Boot Microservice with Docker Compose and Kubernetes

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
   
    
