pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Artifact') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Docker Build & Deploy') {
            steps {
                sh "docker build -t weather-app:latest ."
                sh "docker stop weather-app-container || true"
                sh "docker rm weather-app-container || true"
                sh "docker run -d  --restart unless-stopped --name weather-app-container -p 8081:8081 weather-app:latest"
            }
        }
    }
}