@Library("shared") _
pipeline {
    
    agent {label "vinod"}
    
    stages {
        
        stage("hello") {
            steps {
                script {
                    hello()
                }
            }
        }
        
        stage("code") {
            steps {
                script {
                clone("https://github.com/LondheShubham153/django-notes-app.git", "main")
                }
            }
        }
        
        stage("build") {
            steps {
                script {
                    docker_build("debjyotibiswas", "notes-app", "latest")
                }
            }
        }
        
        stage("test") {
            steps {
                echo "This is testing the code..."
            }
        }
        
        stage("push") {
            steps {
                echo "This is pushing to docker hub..."
                withCredentials([usernamePassword('credentialsId':"dockerhubcred", passwordVariable:"dockerhubpass", usernameVariable:"dockerhubuser")]){
                sh "docker login -u ${env.dockerhubuser} -p ${env.dockerhubpass}"
                sh "docker image tag notes-app:latest debjyotibiswas/notes-app:latest"
                sh "docker push ${env.dockerhubuser}/notes-app:latest"
                }
            }
        }
        
        stage("deploy") {
            steps {
                echo "This is deploying the code..."
                sh "docker run -d -p 8000:8000 notes-app:latest"
            }
        }
    }
}
