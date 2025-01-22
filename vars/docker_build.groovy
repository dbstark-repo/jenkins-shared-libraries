def call(String projectName, String dockerhubuser, String imageTag) {
  echo "This is building the code..."
  sh "whoami"
  sh "docker build -t ${dockerhubuser}/${projectName}:${imageTag} ."
}
