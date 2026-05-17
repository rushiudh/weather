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
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build & Deploy') {
            steps {
                script {
                    def appImage = docker.build("myapp:latest", ".")

                    docker.withServer('unix:///var/run/docker.sock') {
                        sh "docker stop myapp-container || true"
                        sh "docker rm myapp-container || true"
                        appImage.run("-d --name myapp-container -p 8080:8080")
                    }
                }
            }
        }
    }
}