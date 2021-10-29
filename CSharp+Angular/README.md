# Builing App with Dotnet and Angular

## Requirement

```
.NET 5+
Angular 10+
Bootstrap
```

## Check if dotnet is installed correctly

```
dotnet --info
```

## Creating .NET Web API Application

### Step 1 - Create a new Solution File

```
dotnet new sln
```

This will create na new Solution file with the name of containing folder.

### Step 2 - Create a new WebAPI Project

```
dotnet new webapi -o API
```

This will create a new ASP.NET Web API project in Output Directory of API.

### Step 3 - Add API project to Solution

```
dotnet sln add API
```

This will add API project information in the solution file.

### step 4 - Add Dotnet Certificate to trusted list

```
dotnet dev-certs https --trust
```

This adds the Dotnet SAK Certificate to trusted list of OS. On Mac/Linux you may need elevated privileges.

### Step 5 - Run the project

```
cd API
dotnet run
```

To run a project, you first need to be in the project.

If we want the DotNet to look for code changes and automatically rebuild app we can use watch run

```
dotnet watch run
```

## Add GitIgnore to the Porject

```
dotnet new gitignore
```

## Adding Entity Framework to Project

If you are using VSCode, you can use nuGet Gallery Extension to add Entity Framework and Database Provider to the project.  
For SQLite, you would neen

```
Microsoft.EntityFrameworkCore.Sqlite
```

## Install Entity Framework for .NET Core

```
dotnet tool install --global dotnet-ef --version <version of Dotnet>
```

## Create new Migration

Pre-requisite for creating migrtation is adding EntityFramefor Design to Project.  
Install following from NuGet

```
Microsoft.EntityFrameworkCore.Design
```

Then create migration.

```
dotnet ef migrations add <MigrationName> -o <OutputDirectory>
```

## Executing Migrations

```
dotnet ef database update
```

## C# Controller Basic

-   `[ApiController]` decorator tells .NET that following class is an API Controller
-   `[Route("api/[controller]")]` decorator defines the endpoint for Controller. We can use `[controller]` inside route to define default convention.
-   All API Controllers inherit from `ControllerBase`
-   In default convention Prefix before `Controller` in controller name replaces the `[controller]` in route.
-   `[HttpGet]` decorator on a method defines action for GET endpoint.
-   `[HttpGet("{id}")]` GET endpoint can also have parameter which can be used as input. This in envoked when parameter is sent as follow - 'api/controller/id'
-   All ApiMethods must return `ActionResult<DataType>`
-   Async API methods must return `Task<ActionResult<DataType>>`
