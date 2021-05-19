# Docker Training
### Pull Docker images for Container Registry
```
docker pull <image>
```
  
### Pull Specific version by Tag
```
docker pull <image>:<tag>
```
  
### Run Docker Container from images
```
docker run -d -t --name <name for container> <image>
```
  
### See Running Containers
```
docker ps
```
  
### Connect to Running Container
```
docker exec -it <container name> bash
```
  
### Run Docker with port mapping
```
docker run -t -d -p <host Port>:<docker port> --name <name for container> <image>
```
  
### Stop running Docker Container
```
docker stop <container name>
```
  
### Start stopped container
```
docker start <container name>
```
  
### Stats of CPU, Memory and Network usage by Docker containers
```
docker stats
```
  
### Delete a Container
```
docker rm <container name>
```
  
### Delete complete Image 
```
docker rmi <image name>[:<tag if any>]
```
