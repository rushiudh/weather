pipeline {
    agent any

    environment {
        IMAGE_NAME = 'weather-app'
        IMAGE_TAG  = 'latest'
        CONTAINER  = 'weather-app-container'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Artifact') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build & Deploy') {
            steps {
                sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
                sh "docker stop ${CONTAINER} || true"
                sh "docker rm ${CONTAINER} || true"
                sh "docker run -d --name ${CONTAINER} -p 8080:8080 ${IMAGE_NAME}:${IMAGE_TAG}"
            }
        }
    }
}