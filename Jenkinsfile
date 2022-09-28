pipeline {
    agent any

    stages {
        stage('scm') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/vinod-kayartaya/springboot-customer-service.git'
            }
        }
        
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
                sh 'docker build -t user-service:latest .'
            }
        }
            
        }
    }

