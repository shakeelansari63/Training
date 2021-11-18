# Builing App with Dotnet and Angular

# API

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
For SQLite, you would need

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

## Adding Cors

CORS are added in Startup.cs file otherwise API will not allow any app access to its endpoints.  
_ConfigureServices_ method

```c#
services.AddCors();
```

_Configure_ method

```c#
app.UseCors(policy => policy.AllowAnyHeader().AllowAnyMethod().WithOrigins("http://localhost:4200"));
```

## Adding Services
Inside `ConfigureServices` method of `Startup.cs` add new Services using either of bellow 3 methods.
```c#
services.AddSingleton<Interface, Implementation>(); // Initialise with app start and lives till lifecycle of app
services.AddScoped<Interface, Implementation>(); // Initialise with HttpRequest and end with request
services.AddTransient<Interface, Implementation>(); // Initialise with method execution and ends with method. Not considered suitable for Http.
```

## Creating JWT Token for Authentication to API
 - Install following package
 ```
 System.IdentityModel.Tokens.Jwt
 ```
 
 - Create Token Service and corresponding interface and add then to Configuration
 ```c#
 service.AddScoped<ITokenService, TokenService>();
 ```

 - Take a look at ITokenService and TokenService in this app

 - Call Token Services in Controller for creating Tokens

## Validating JWT Token in API
 - Install following Package
 ```
 Microsoft.AspNetCore.Authentication.JwtBearer
 ```

 - Add Authorize Annotation to Controllers. We can add Annotation to Controller or Controller functions.  
  Easiest option is to add `[Authorize]` annotation on Base controller and `[AllowAnonymous]` annotation on Register/Login Controller.

 - Add Authentication option in `ConfigureServices` method of Startup Class
 ```c#
 services.AddAuthentication(JwtBearerDefaults.AuthenticationScheme)
    .AddJwtBearer(option => {
        option.TokenValidationParameters = new TokenValidationParameters
        {
            ValidateIssuerSigningKey = true,
            IssuerSigningKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(_config["TokenKey"])),
            ValidateIssuer = false,
            ValidateAudience = false
        };
    });
 ```

 - Add UseAuthentication in `Configure` method
 ```
 app.UseAuthentication();
 ```

# Client App

## Requirement

```
Angular 10+
Bootatrap (use ngx-bootstrap)
```

## Installing Angular

```
npm install -g @angular/cli
```

## Create new App with Angular CLI

```
ng new AppName
```

## Add Bootstrap to Angular App

```
ng add ngx-bootstrap
```

## Add SSL Layer to Angular

Update _angular.json_ - _server_ section

```json
"options": {
    "sslCert": "./ssl/server.crt",
    "sslKey": "./ssl/server.key",
    "ssl": true
},
```

## Using Toast Notifiation
```
npm install ngx-toastr
```
  
Import following in app module
```ts
ToastrModule.forRoot({positionClass: 'toast-bottom-right'})
```

And inject ToastrService to show toast
  
## Using Bootstrap Themes
```
npm install bootswatch
```
  
Import bootswatch scss in following sequence
```scss
@import "~bootswatch/dist/[theme]/variables";
@import "~bootstrap/scss/bootstrap";
@import "~bootswatch/dist/[theme]/bootswatch";
````