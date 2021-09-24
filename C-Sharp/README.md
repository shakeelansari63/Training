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

# Run a project
```
dotnet run
```

# Run project with watching changes to any file
```
dotnet watch run
```

# Add more packages when required
```
dotnet add package Microsoft.EntityFrameworkCore.SqlServer
```

# Download and install package
dotnet add package only adds package in csproj file. In order to download and start using it, we need to run dotnet restore
```
dotnet restore
```

# Adding Entity Framework Command Line Tool to project
Add following line in .csproj
```xml
<ItemGroup>
	<DotNetCliToolReference Include="Microsoft.EntityFrameworkCore.Tools.DotNet" Version="2.0.3" />
</ItemGroup>
```