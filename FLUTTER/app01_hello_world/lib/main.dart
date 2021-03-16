// material package has built in widgets which we can use
import 'package:flutter/material.dart';

// Main is entry point for any flutter app
void main() {
  // Flutter is made of widgets. Everything on flutter is widget
  // so to show anythong on screen, we need to have a widget

  // Since we have below HelloWorld Class created which create a widget
  // We can now run it using runApp and creating instance of our class
  // var app = HelloWorldApp();
  var app = AppWithBar();
  runApp(app);
}

// Since flutter is defined as dependency for this app in pubspec.yml,
// we can use classes defined in flutter package
// Here we create a new class which inherit the widget ffrom flutter package
// We use stateless widget from material pacakge

class HelloWorldApp extends StatelessWidget {
  // Stateless Widget is abstract so it is necessary that we implement the
  // required method.
  // Here we implement the build method which is mandatory for Stateless Widgets

  // Build method takes Build Context as inut
  // Build method also return a widget which will be drawn in screen
  @override
  Widget build(BuildContext ctx) {
    // Since we have to return a widget, here we return MatrialApp widget
    // And set the home parameter to a text widget
    return MaterialApp(
      home: Text('Hello World'),
    );
  }
}

// Here is my app with Scaffold
class AppWithBar extends StatelessWidget {
  @override
  Widget build(BuildContext ctx) {
    // Define AppBar
    var appBar = AppBar(title: Text('My App Bar'));

    // Body
    var body = Text('My App Body');

    // Scaffold is app with app bar
    var mainWin = Scaffold(
      appBar: appBar,
      body: body,
    );

    // Create material app
    return MaterialApp(home: mainWin);
  }
}
