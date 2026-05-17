pipeline {
    agent any
    environment {
            IMAGE_NAME = 'myapp'
            IMAGE_TAG  = 'latest'
            CONTAINER  = 'myapp-container'
        }

    stages {

        stage('Clone') {
            steps {
                git branch: 'develop',
                url: 'https://github.com/rushiudh/weather'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
                    steps {
                        sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
                    }
                }

        stage('Stop Old App') {
            steps {
                sh '''
                lsof -ti:8081 | xargs kill -9 || true
                '''
            }
        }

        stage('Run App') {
            steps {
                sh '''
                nohup java -jar target/*.jar > app.log 2>&1 &
                '''
            }
        }
    }
}