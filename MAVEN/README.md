# Create new Project
```console
mvn archetype:generate -DgroupId=com.bharath -DartifactId=hellomaven -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

# Compile & Package Maven Project
```console
mvn clean install
```

After successful compile and packaging, it will generate jar file in target

# Execute JAR
```console
java -cp <jar file name> <class name>
```

