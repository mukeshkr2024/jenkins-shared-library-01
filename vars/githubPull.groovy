#!/usr/bin/env groovy

def call(){
    echo 'Building the application...'
    sh "git pull origin $BRANCH_NAME"
}