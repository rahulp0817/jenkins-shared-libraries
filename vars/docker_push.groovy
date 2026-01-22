def deploy(String Project, String ImageTag, String dockerhubuser){
    echo "Deploying the code..."
    withCredentials([usernamePassword('credentialsId': "dockerHubCred", passwordVariable:"dockerHubPass", usernameVariable: "dockerHubUser")]){
		      sh """
              echo "${dockerHubPass}" | docker login -u "${dockerHubUser}" --password-stdin
             """
		      sh "docker image tag webrtc-app:latest ${env.dockerHubUser}/webrtc-app:latest"
		      sh "docker push ${env.dockerHubUser}/${Project}:${ImageTag}"
    }
}
