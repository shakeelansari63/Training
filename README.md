# C# development in Linux using Mono Project

# Install Mono on Linux
### Arch Linux / Manjaro
```
pamac install mono mono-addins mono-tools
```

## To compile CS file
```
mcs <filename>.cs
```

## To run compiled EXE file
```
mono <filename>.exe
```

## To run ASP.NET Project, you would need XSP
XSP is in AUR repository in Arch Linux

```
pamac install xsp
```

# Creating new ASP.NET and Angular project with 
```
dotnet new angular

```

# Run Dotnet Project 
```
dotnet run
```

# Watch and Autocompile changes in Dotnet Project
In order to autocompile any changes in dotnet server side project, we should run following command
```
dotnet watch run
```