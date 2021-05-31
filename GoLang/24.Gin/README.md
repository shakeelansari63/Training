# Gin Module
Gin uses Go modules which have been introduced in GO v1.11  
Here are steps to import modules in Go Program  
  
## Install Gin Module
```
go get -u github.com/gin-gonic/gin
```
  
## Create your project Folder and initialize with Go Module
```
mkdir GinTest
cd GinTest
go mod init <project name> # Example project name: github.com/shakeelansari63/gintest
```
  
After initialization, it will create a go.mod file which will have project detail
  
## Create all project code using Gin module inside the project directory
  
## Tidy Project to get all packages required
```
go tidy
```
  
This will add all used moduled in go.mod and checksum in go.sum
  
## Run the Project main file
```
go run main.go
```


