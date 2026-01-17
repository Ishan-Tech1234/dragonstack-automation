pipeline {
    agent any

    environment {
        BASE_URL = 'http://localhost:1234'
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
