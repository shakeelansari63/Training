import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<StatefulWidget> createState() {
    return _MyAppState();
  }
}

class _MyAppState extends State<MyApp> {
  final _questions = [
    'What is your favorite color?',
    'What is your favorite animal?',
  ];

  var _questionIdx = 1;

  void _answered() {
    setState(() {
      _questionIdx =
          _questionIdx == _questions.length - 1 ? 0 : _questionIdx + 1;
    });

    print(_questionIdx);
  }

  @override
  Widget build(BuildContext ctx) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Quiz App'),
        ),
        body: Column(
          children: [
            Text(_questions[_questionIdx]),
            ElevatedButton(onPressed: _answered, child: const Text('Answer 1')),
            ElevatedButton(onPressed: _answered, child: const Text('Answer 2')),
            ElevatedButton(onPressed: _answered, child: const Text('Answer 3')),
          ],
        ),
      ),
    );
  }
}
