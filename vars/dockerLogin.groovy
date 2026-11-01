def call()
{
  echo "Inside the shared library"
  withCredentials([usernamePassword(
                credentialsId:'docker-hub-cred',
                passwordVariable:"dockerHubPass",
                usernameVariable:"dockerHubUser")])
  {
  sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
  sh "docker tag my_notes:latest  ${env.dockerHubUser}/my_notes:latest"
  }
}
