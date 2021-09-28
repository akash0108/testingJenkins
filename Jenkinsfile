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
                    withCredentials([usernamePassword(creddentialsID:'docker-credentials',passwordVariable: 'PASS',usernameVariable: 'USER')]){
                        sh 'docker build -t akash41287/mishra:jenkinsPipeline .'
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'docker push akash41287/mishra:jenkinsPipeline'
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
