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
        stage('Compile') {
            steps {
                // Run Maven on a Unix agent.
                bat "mvn -Dmaven.test.failure.ignore=true compile"
                echo 'Compilando'
            }
        }
        stage('Package') {
            steps {
                // Run Maven on a Unix agent.
                bat "mvn -Dmaven.test.failure.ignore=true package"
                echo 'Empaquetando'
            }
        }
    }
}
