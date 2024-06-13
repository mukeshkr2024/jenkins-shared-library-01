#!/usr/bin/env groovy

def call(){
   echo 'Building the Docker image...'
    withCredentials([usernamePassword(credentialsId: 'docker-hup-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t $USER/jenkins-pipe:v-1.0 ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push $USER/jenkins-pipe:v-1.0"
    }
}