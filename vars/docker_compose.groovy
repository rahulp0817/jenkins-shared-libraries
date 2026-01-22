def deploy(){
  echo "Deploying the code..."
  sh "docker-compose down && docker-compose up -d"
}
