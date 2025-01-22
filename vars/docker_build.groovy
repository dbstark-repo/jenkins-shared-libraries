def call(String projectName, String dockerHubUser, String imageTag) {
  echo "This is building the code..."
  sh "whoami"
  sh "docker build -t ${dockerHubUser}/${projectName}:${imageTag} ."
}
