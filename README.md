🚀 3-Tier Java Application – DevOps CI/CD Pipeline













📌 Project Overview

This project demonstrates the deployment of a 3-Tier Java-based application using a complete DevOps CI/CD pipeline.

The project automates the application delivery lifecycle from source code management to build, testing, code-quality analysis, containerization, artifact storage, Kubernetes deployment, and verification.

The infrastructure was implemented on AWS EC2 using Ubuntu Linux.

🏗️ Architecture
Developer
    │
    ▼
 GitHub
    │
    ▼
 Jenkins
    │
    ├── Maven Build
    ├── JUnit Tests
    └── SonarQube Analysis
            │
            ▼
         Docker
            │
            ▼
          Nexus
       Docker Registry
            │
            ▼
      Kubernetes / k3s
            │
         Traefik
            │
            ▼
      Java Backend Pod
            │
            ▼
       Application

The complete DevOps environment runs on AWS EC2 Ubuntu infrastructure.

🔄 CI/CD Pipeline

The Jenkins pipeline follows this workflow:

GitHub
   ↓
Checkout
   ↓
Maven Build
   ↓
Unit Testing
   ↓
SonarQube Analysis
   ↓
Docker Image Build
   ↓
Push Image to Nexus
   ↓
Kubernetes Deployment
   ↓
Deployment Verification
Pipeline Stages
Stage	Tool	Purpose
Source Code	GitHub	Store and manage source code
Build	Maven	Compile and package the Java application
Testing	JUnit	Run automated unit tests
Code Quality	SonarQube	Analyze code quality and security
Containerization	Docker	Build application container image
Image Repository	Nexus	Store Docker images
Deployment	Kubernetes / k3s	Deploy the application
Ingress	Traefik	Handle application traffic
Verification	kubectl / Jenkins	Verify deployment and pod status
🛠️ Tech Stack
Application
Java
Spring Boot
Maven
JUnit
DevOps & CI/CD
Git
GitHub
Jenkins
SonarQube
Docker
Nexus Repository
Container Orchestration
Kubernetes
k3s
Traefik
containerd
Cloud & Infrastructure
AWS EC2
Ubuntu Linux
AWS IAM
AWS Systems Manager
SSH
🚀 What We Implemented
Developed and tested a Java-based 3-tier application with frontend and backend components.
Built an automated Jenkins CI/CD pipeline for Maven build, unit testing, SonarQube analysis, Docker image creation, and Nexus repository push.
Containerized the backend application using Docker and deployed it on a Kubernetes/k3s cluster with Traefik.
Troubleshot real-world issues involving Jenkins, Docker, Nexus, Kubernetes/k3s, containerd, SSH, disk space, and AWS infrastructure.
🧪 Testing

Unit testing was implemented using JUnit.

Example test:

backend/src/test/java/com/amit/backend/controller/HelloControllerTest.java

Tests are executed as part of the Maven/Jenkins pipeline.

🐳 Docker & Nexus

The application was containerized using Docker.

Example Docker image:

java-3tier-backend:1.0

The image was tagged and pushed to the Nexus Docker repository:

docker tag java-3tier-backend:1.0 localhost:8082/java-3tier-backend:1.0

docker push localhost:8082/java-3tier-backend:1.0

Nexus was configured as a private Docker hosted repository using port 8082.

☸️ Kubernetes Deployment

The Dockerized Java application was deployed to a k3s Kubernetes cluster.

Deployment was verified using:

kubectl get pods

The application pod was successfully brought to:

1/1 Running

We also verified Kubernetes services and Traefik components.

📊 Monitoring & Verification

The project includes infrastructure and deployment monitoring/verification using:

Jenkins build status and console logs
Docker container and image status
Kubernetes pod and service status
k3s service status
containerd logs
Linux system and disk monitoring
AWS Systems Manager
AWS infrastructure monitoring
🔧 Troubleshooting

During implementation, several real-world infrastructure issues were identified and resolved.

Kubernetes Image Pull Issue

Initially, the application pod encountered:

ErrImagePull

The issue was investigated and the Docker image was made available to the k3s/containerd environment.

The application was then successfully deployed and verified as:

1/1 Running
Other Troubleshooting

We also worked on:

k3s service and containerd issues
Traefik status/issues
Jenkins configuration
Nexus memory optimization
SSH connectivity and Security Group configuration
EC2 public IP changes
Linux disk and partition management
📁 Project Structure
java-3tier-devops/
│
├── backend/
│   ├── src/
│   ├── pom.xml
│   └── Dockerfile
│
├── frontend/
│   └── ...
│
├── Jenkinsfile
└── README.md
🎯 Key Highlights
End-to-end CI/CD automation using Jenkins
Automated Maven build and JUnit testing
SonarQube code-quality integration
Docker-based application containerization
Private Docker image management using Nexus
Kubernetes/k3s deployment
Traefik-based traffic handling
AWS EC2-based DevOps infrastructure
Real-world DevOps troubleshooting and deployment verification
🔗 Repository

GitHub:
https://github.com/amitd1299/java-3tier-devops

👨‍💻 Author

Amit Dorwekar

DevOps Engineer

GitHub: https://github.com/amitd1299
LinkedIn: https://www.linkedin.com/in/amit-dorwekar
