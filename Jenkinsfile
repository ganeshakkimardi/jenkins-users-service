pipeline {
    agent any

    stages {
        
        stage('clean'){
            steps{
                sh 'mvn clean'
            }
        }
        
        stage('compile'){
            steps{
                sh 'mvn compile'
            }
        }
        
        /*
        stage('quality'){
            steps{
                sh 'mvn sonar:sonar'
            }
        }
        */
        
        stage('test'){
            steps{
                sh 'echo skipping'
            }
        }
        
        stage('jar'){
            steps{
                sh 'mvn clean package -DskipTests=true'
            }
        }
        
        stage('dockerize'){
            steps{
                sh 'docker build -t users-service:latest .'
            }
        }
        
        stage('integration tests'){
            steps{
                sh 'docker run -dp 7070:8080 --rm --name tmp-user-service-container users-service:latest'
                sleep 10
                sh 'curl -i http://localhost:7070/api/users'
            }
        }
            
        }
        
        post{
            always{
                sh 'docker stop tmp-user-service-container'
            }

        }

    }

