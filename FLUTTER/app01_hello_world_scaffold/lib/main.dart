import 'package:flutter/material.dart';

void main() => runApp(MyScaffoldApp());

class MyScaffoldApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Scaffold App'),
        ),
        body: const Text('Hello World'),
      ),
    );
  }
}
