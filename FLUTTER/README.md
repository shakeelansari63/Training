# Flutter App

A new Flutter project.

## Getting Started

This project is a starting point for a Flutter application.

A few resources to get you started if this is your first Flutter project:

- [Lab: Write your first Flutter app](https://flutter.dev/docs/get-started/codelab)
- [Cookbook: Useful Flutter samples](https://flutter.dev/docs/cookbook)

For help getting started with Flutter, view our 
[online documentation](https://flutter.dev/docs), which offers tutorials, 
samples, guidance on mobile development, and a full API reference.

## Flutter Commands
### Check Flutter installation and dependencies are correct
```
flutter doctor
```
  
### Create Flutter Project
```
flutter create Project_Name
```
Note: The project name should be one word seperated by "_"(underscores), spaces or dashes are not allowed.
  
### Run Flutter App
```
flutter run
```  
  
### Stateless vs Stateful Widgets
Stateless widgets can get data from external source and render the UI. But once the ui is rendered, they do not change. 
Stateful widgets can also get data from external sources, but they can also have internal state. And if external data change or internal state change, the stateful widget re-renders the ui. 

### Installing 3rd Party Packages from Pub.dev
Update the pubspec.yaml file in dependency section to install 3rd party packages.  
On saving the pubspec.yaml, Dart should automatically get the package and install.
```
dependency:
  flutter:
    sdk: flutter
  intl: ^0.15.8
```  

  
