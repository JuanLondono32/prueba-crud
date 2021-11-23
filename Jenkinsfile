pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "Maven 3.8.3"
    }

    stages {
        stage('Clean'){
            steps{
                // Get some code from a GitHub repository
                bat "mvn -Dmaven.test.failure.ignore=true clean"
            }
        }
        stage('Build') {
            steps {
                // Run Maven on a Unix agent.
                bat "mvn -Dmaven.test.failure.ignore=true package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
    }
}
