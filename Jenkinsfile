pipeline {
    agent any

    tools {
        jdk 'jdk8'        // Uses Jenkins-managed JDK
        maven 'maven3'    // Uses Jenkins-managed Maven
    }

    environment {
        BASE_URL = 'http://localhost:1234'
    }

    triggers {
        cron('H 9 * * 1-5')   // Runs every weekday around 9 AM
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test -DbaseUrl=%BASE_URL%'
            }
        }
    }

    post {
        always {
            publishTestNGResults testResultsPattern: 'target/surefire-reports/testng-results.xml'
        }

        success {
            echo 'Pipeline executed successfully.'
        }

        failure {
            echo 'Tests failed. Check TestNG report.'
        }
    }
}
