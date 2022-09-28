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
        
        stage('test'){
            steps{
                sh "echo skipping"
            }
        }
        
        stage('build'){
            steps{
                sh 'mvn clean package -DskipTests=true'
            }
        }
            
        }
    }

