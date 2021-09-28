def gv

pipeline {
    agent any 
    tools{
        maven 'maven'
    }
    stages{
        stage "init" {
            step{
                script {
                    gv = load"script.groovy"
                }
            }

        }
        stage ("build Jar"){
            steps {
                script{
                    gv.buildJar()
                }
            }
        }
        stage ("Docker image"){
            steps {
                script{
                    gv.buildImage()
                    
                }
            }
        }
        stage ("deploy"){
            steps {
		gv.deployAPP()
            }
        }
    }
}
