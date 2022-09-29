pipeline {
    agent any
    
    environment{
        DOCKER_IMG_NAME = 'users-service'
        DOCKER_TMP_CONTAINER_NAME = 'tmp-user-service-container'
        DOCKER_REPO='ganeshakkimardi'
    }


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
                sh 'docker build -t ${DOCKER_REPO}/${DOCKER_IMG_NAME}:latest -t ${DOCKER_REPO}/${DOCKER_IMG_NAME}:${BUILD_ID} .'
            }
        }
        
        
        stage('integration tests'){
            steps{
                sh 'docker run -dp 7070:8080 --rm --name ${DOCKER_TMP_CONTAINER_NAME} ${DOCKER_REPO}/${DOCKER_IMG_NAME}:latest'
                sleep 10
                sh 'curl -i http://localhost:7070/api/users'
            }
        }
        
        stage('docker publish'){
            steps{
            withDockerRegistry([ credentialsId: 'docker_creds', url: '']){
            		sh 'docker push ${DOCKER_REPO}/${DOCKER_IMG_NAME}:${BUILD_ID}'
                    sh 'docker push ${DOCKER_REPO}/${DOCKER_IMG_NAME}:latest'                                              
                }

            }
        }
        
            
     }
        
        post{
            always{
                sh 'docker stop ${DOCKER_TMP_CONTAINER_NAME}'
                sh 'docker rmi ${DOCKER_REPO}/${DOCKER_IMG_NAME}:latest ${DOCKER_REPO}/${DOCKER_IMG_NAME}:${BUILD_ID}'
            }

        }

    }

