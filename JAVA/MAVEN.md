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
<project
    xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    
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

## Maven Dependencies
Maven dependencies are added to `<dependencies></dependencies>` section of the POM file.  
E.g.  
```xml
<project ...>
    ...
    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>5.3.20</version>
        </dependency>
    </dependencies>
</project>
```

## Dependency Scopes
Scopes in maven are used to control the visibility and lifecycle of dependencies. Here are the different scopes available in Maven:
  
### Compile **(DEFAULT)**
Dependencies with the compile scope are included in the project's classpath during compilation and runtime.
  
### Provided
Dependencies with the provided scope are included in the project's classpath during compilation but are not included in the final JAR file. This is typically used for dependencies that are provided by the runtime environment.
  
### Runtime
Dependencies with the runtime scope are included in the project's classpath during runtime but not during compilation.
  
### Test
Dependencies with the test scope are only included in the project's classpath during testing.
  
### System **\*NEVER USE THIS SCOPE\***
Dependencies with the system scope are included in the project's classpath but are not downloaded from a remote repository. Instead, they are expected to be provided by the runtime environment.
  
### Import
Dependencies with the import scope are used to import the dependencies of another project. This is typically used when working with multi-module projects.
  
## Maven Repos
Repositories are remote locations where Maven downloads dependencies from. They can be configured in the `<repositories></repositories>` section of the POM file. A maven project can have more than one repos to download dependencies from.
  
Here is sample repo declaration in `pom.xml`:
```xml
<repositories>
    <repository>
        <id>central</id>
        <url>https://repo.maven.apache.org/maven2</url>
    </repository>
</repositories>
```

### Default Maven Repos
Maven provide some Central repo where most of the dependencies are hosted.   
- Central Repository : https://repo.maven.apache.org/maven2
- Maven Central Repository : https://repo1.maven.org/maven2

## Maven Phases
  
Maven has several phases that are executed in a specific order. Each phase performs a specific task. The phases are:
  
- validate : Validate the project is correct and all necessary information is available.
- compile : Compile the source code of the project.
- test : Test the compiled source code using a suitable unit testing framework.
- package : Package the compiled code into a distributable format, such as a JAR or WAR file.
- install : Install the package into the local repository, for use as a dependency in other projects locally.
- deploy : Deploy the final package to the remote repository for sharing with other developers and projects.
  
Maven Goals are usually executed as part of a phase. For example, the `compile` phase will execute the `compile` goal of the `maven-compiler-plugin`.
  
## Maven Plugins
Plugins are used to extend the functionality of Maven. They can be configured in the `<plugins></plugins>` section of the POM file. A maven project can have more than one plugins to perform different tasks.
  
Here is sample plugin declaration in `pom.xml`:
```xml
<plugins>
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
        <configuration>
            <source>1.8</source>
            <target>1.8</target>
        </configuration>
    </plugin>
</plugins>
```
  
### Sample Plugins
Maven provide some default plugins which are used to build, test and deploy the project.   
- Compiler Plugin : https://maven.apache.org/plugins/maven-compiler-plugin/
- Source Plugin : https://maven.apache.org/plugins/maven-source-plugin/
- Deploy Plugin : https://maven.apache.org/plugins/maven-deploy-plugin/
  
## Maven Plugin Configurations
Plugin configurations are used to customize the behavior of plugins. They can be configured in the `<configuration></configuration>` section of the plugin declaration. A plugin can have more than one configuration to perform different tasks.
  
Here is sample plugin configuration in `pom.xml`:
```xml
<plugins>
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
        <configuration>
            <release>17</release>
        </configuration>
    </plugin>
</plugins>
```
  
## Maven Plugin Execution Config
Plugin executions setups are used to execute the plugin goals. They can be configured in the `<executions></executions>` section of the plugin declaration. A plugin can have more than one execution to perform different tasks.
  
Here is sample plugin execution configuration in `pom.xml`:
```xml
<plugins>
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
        <executions>
            <execution>
                <id>default-compile</id>
                <phase>compile</phase>
                <goals>
                    <goal>compile</goal>
                </goals>
            </execution>
        </executions>
    </plugin>
</plugins>
```
