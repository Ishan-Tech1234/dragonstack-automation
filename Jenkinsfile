pipeline {
    agent any

    tools {
        jdk 'jdk8'
        maven 'maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test -DbaseUrl=http://localhost:1234'
            }
        }
    }

    post {
        always {
            step([$class: 'Publisher',
                  reportFilenamePattern: 'testng-results.xml',
                  reportFilePath: 'target/surefire-reports',
                  escapeTestDescription: false,
                  escapeExceptionMessages: false,
                  showFailedBuilds: true])
        }
        success {
            echo 'Pipeline executed successfully.'
        }
        failure {
            echo 'Tests failed. Check TestNG report.'
        }
    }
}
