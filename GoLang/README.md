# Go Lang

## Installation

Get binaries from web and put them in local.  
Add the binary path to your path.

## Initialize Go Project

Run following command inside project directory to initialize Go module

```bash
go mod init project_name
```

This will create go.mod file in directory

## Go Project Structure

```
Projects
   |_ bin
   |_ pkg
   |_ src
       |_ github.com
            |_ [username]
                 |_ [projectname]
                      |_ Main.go
                      .
                      .
                      .
```

## Quickly Run a Go Program for test

```
go run [programname].go
```

## See data usage in go application and go routines

```
go run -race [programname].go
```

## Compiling build/project

```
go build github.com/[username]/[projectname]
```

## Install Binary

```
go install github.com/[username]/[projectname]
```

After running below command, it will generate binary in bin directory

## Installing 3rd Party Libraries form Git

```
go get -v github.com/[3pty_username]/[3pty_project]
```
