# Clean the Project Folder
mvn clean -f ./Docker/pom.xml

# Package App
mvn package -f ./Docker/pom.xml

# Build Docker Image
docker build -f ./Docker/devops/Dockerfile -t helloapp .

# Run the Docker Container in background
docker_id=`docker run -d helloapp`

echo 'CardsApp docker running with Docker ID ; '${docker_id}

# Get registered docker list
docker images

# Get list of running Docker
docker ps -a

# Comment below steps if you want to work with the docker
# Stop Docker 
docker stop ${docker_id}

# Remove Docker Container
docker rm ${docker_id}

# Remove Docker Image 
docker rmi helloapp

# Build and Run Docker from Docker Compose
docker-compose -f ./Docker/devops/docker-compose.yml up -d

# List all running containers
docker ps -a

# Stop running containers
docker-compose -f ./Docker/devops/docker-compose.yml down

# Remove all containers and Images
docker rm `docker ps -a -q`
docker rmi `docker images -a -q`
