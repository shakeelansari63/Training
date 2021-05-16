import 'package:flutter/material.dart';

void main() => runApp(TextChange());

class TextChange extends StatefulWidget {
  // To create state
  State createState() {
    return TextChangeState();
  }
}

class TextChangeState extends State {
  String text = 'Hello World!!';
  // Build method
  Widget build(BuildContext ctx) {
    var appBody = Column(
      children: [
        Container(
          width: double.infinity,
          child: Text(
            this.text,
            textAlign: TextAlign.center,
            style: TextStyle(fontSize: 30),
          ),
        ),
        ElevatedButton(
          onPressed: changeText,
          child: Text('Change Text'),
        )
      ],
    );

    var mainWin = Scaffold(
      appBar: AppBar(
        title: Text('Text Changer'),
      ),
      body: appBody,
    );

    return MaterialApp(
      home: mainWin,
    );
  }

  void changeText() {
    // Set state to rebuild app
    setState(() {
      this.text = 'How is it going !!!';
    });
  }
}
