pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'CleanAndCompile Stage'
                withMaven(maven: 'mvn_3_6_0'){
                		sh 'mvn clean compile'
                }
            }
        }
        stage('Test Stage') {
            steps {
                echo 'Testing..'
                withMaven(maven: 'mvn_3_6_0'){
                		sh 'mvn clean test'
                }
            }
        }
        stage('Deploy Stage') {
            steps {
                echo 'Deploying....'
                withMaven(maven: 'mvn_3_6_0'){
                		sh 'mvn clean deploy'
                }
            }
        }
    }
}