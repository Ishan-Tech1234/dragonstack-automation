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
                bat '''
                    echo JAVA_HOME=%JAVA_HOME%
                    java -version
                    mvn -version
                    mvn clean test -DbaseUrl=http://localhost:1234
                '''
            }
        }
    }

    post {
        always {
            testNG(
                testResultsPattern: 'target/surefire-reports/testng-results.xml'
            )
        }
        success {
            echo 'Pipeline executed successfully.'
        }
        failure {
            echo 'Tests failed. Check TestNG report.'
        }
    }
}
