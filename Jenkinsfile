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
            // ✅ Publish TestNG XML results (plugin-compatible)
            testNG(
                reportFilenamePattern: 'testng-results.xml',
                escapeExceptionMsg: true,
                escapeTestDescp: true,
                showFailedBuilds: true,
                unstableSkips: 0
            )

            // ✅ Publish HTML TestNG Report
            publishHTML([
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'test-output',
                reportFiles: 'index.html',
                reportName: 'TestNG HTML Report'
            ])
        }

        success {
            echo 'Pipeline executed successfully.'
        }

        failure {
            echo 'Tests failed. Check reports.'
        }
    }
}
