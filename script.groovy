def buildJar() {
    echo "Building the application"
 sh 'mvn package'
}

def buildImage() {
    echo "Building the Docker image"
    withCredentials([usernamePassword(credentialsId: 'docker-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
    sh 'docker build -t akash41287/mishra:TestingJenkins .'
    sh "echo $PASS | docker login -u $USER --password-stdin"
    sh 'docker push akash41287/mishra:TestingJenkins'
                      }

}

def deployAPP() {
    echo "deploy App"
}


return this 