pipeline {
    agent any

    stages {

        stage('Clone') {
            steps {
                git branch: 'develop',
                url: 'https://github.com/rushiudh/weather'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Stop Old App') {
            steps {
                sh '''
                pkill -f 'java -jar' || true
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