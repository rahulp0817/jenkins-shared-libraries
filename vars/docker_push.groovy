def call(String project, String imageTag, String dockerHubUser) {
    echo "pushing Docker image..."

    withCredentials([
        usernamePassword(
            credentialsId: "dockerHubCred",
            usernameVariable: "DOCKER_USER",
            passwordVariable: "DOCKER_PASS"
        )
    ]) {
        sh '''
          echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
        '''
    }

    sh "docker push ${dockerHubUser}/${project}:${imageTag}"
}
