# Maven
Maven follows a principle of convention over configuration. This means that Maven provides a set of default conventions for organizing your project structure and build process. 
  
## New project
Maven's convention is to use a specific directory structure for organizing your project. The following is a typical Maven project structure:
  
```
my-project/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   ├── resources/
│   │   └── webapp/
│   └── test/
│       ├── java/
│       └── resources/
└── target/
```

## POM
`pom.xml` is the heart of a Maven project. It contains all the metadata and configuration information needed to build, test, and deploy your project. Here's an example of a basic `pom.xml` file:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>my-project</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>
</project>
```

## Maven Goals
Maven provides a set of predefined goals that you can use to automate various tasks in your project. Here are some of the most commonly used goals:
  
### Clean 
Cleans the project target directory
```
mvn clean
```
  
### Compile
Compiles the project and stores the classes in the target/classes directory
```
mvn compile
```
  
### Package
Packages the project into a JAR file or whatever format you specify in the packaging element of the POM file
```
mvn package
```
  
### Install
Installs the project into the local repository. This makes the project available for other projects to use as a dependency.
```
mvn install
```
  
### Deploy
Deploys the project to a remote repository
```
mvn deploy
```
