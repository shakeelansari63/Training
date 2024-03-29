# ANGULAR

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 12.0.1.
  
## Install Angular CLI
```
npm install -g @angular/cli
```
  
## Create new Project
  
Run `ng new <project name>` to create new Angular Project
  
## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via a platform of your choice. To use this command, you need to first add a package that implements end-to-end testing capabilities.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.

## Project Structure
```
Project
  |-- node_modules (All Required node modules)
  |-- src (Main Source Folder where we edit stuff)
       |-- app (Application Related components)
       |    |-- *.css (App Component CSS)
       |    |-- *.html (App Component HTML)
       |    |-- *.ts (App Component TS)
       |-- index.html (Main HTML that loads all) 
       |-- styles.css (Global Styling CSS)
```
  
## For Awesome Fonts
```
ng add @fortawesome/angular-fontawesome
```
  
#### In order to use Font Awesome, we need to add it to App.module and import it
  
## Useful Ng Directives
Directives in () are Output Directives whereas that in [] are input Directives. For 2 way Linking use [()] directives.  
  
### (click) 
Action on Object is clicked
  
### (dblclick)
Action when object is double clicked
  
### [ngStyle]
Provide inline CSS Styling for object
  
### [ngClass]
Specify class for an object on specific condition
  
### *ngFor
Duplicate object for the list of objects
  
### *ngIf
Displat the component only if condition is True
  
### (ngSubmit)
Action on Form Submit
  
### [(ngModel)]
Two way linking HTML inut object with Class property. When using ngModel make sure input object has name parameter which matches the name of property in class.
