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
            
        }
    }

