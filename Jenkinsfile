pipeline {
    agent any 
    tools{
        maven 'maven'
    }
    stages{
        stage ("build Jar"){
            steps {
                script{
                    echo "Building the application"
                    sh 'mvn package'
                }
            }
        }
        stage ("Docker image"){
            steps {
                script{
                    echo "Building the Docker image"
                    withCredentials([usernamePassword(credentialsId: 'docker-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                    sh 'docker build -t akash41287/mishra:TestingJenkins .'
                    sh "echo $PASS | docker login -u $USER --password-stdin"
                    sh 'docker push akash41287/mishra:TestingJenkins'
                      }
                    
                }
            }
        }
        stage ("deploy"){
            steps {
                echo "deploy App"
            }
        }
    }
}
