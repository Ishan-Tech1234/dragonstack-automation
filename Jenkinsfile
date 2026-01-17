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
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {

            testNG(
                reportFilenamePattern: 'target/surefire-reports/testng-results.xml',
                allowEmptyResults: true
            )

            publishHTML([
                allowMissing: true,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'test-output',
                reportFiles: 'index.html',
                reportName: 'TestNG HTML Report'
            ])
        }

        success {
            echo 'All tests passed successfully.'
        }
}
}