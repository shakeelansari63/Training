import 'package:flutter/material.dart';

void main() => runApp(MyScaffoldApp());

class MyScaffoldApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Scaffold App'),
        ),
        body: Text('Hello World'),
      ),
    );
  }
}
