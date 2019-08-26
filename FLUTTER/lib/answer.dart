import 'package:flutter/material.dart';

class Answer extends StatelessWidget {
  final String answerText;
  final Function keyActionCallback;

  Answer(this.answerText, this.keyActionCallback);
  @override
  Widget build(BuildContext context) {
    return Container(
      width: double.infinity ,
      child: RaisedButton(
        child: Text(answerText), 
        onPressed: keyActionCallback,
        color: Colors.blue,
        textColor: Colors.white,
      ),
      margin: EdgeInsets.all(10)
    );
  }
}