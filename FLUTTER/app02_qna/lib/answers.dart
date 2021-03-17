import 'package:flutter/material.dart';

class Answer extends StatelessWidget {
  // Callback for Button pressed action
  final Function answerAction;
  final String buttonText;

  Answer(this.buttonText, this.answerAction);

  @override
  Widget build(BuildContext context) {
    return Container(
      width: double.infinity,
      margin: EdgeInsets.symmetric(horizontal: 10, vertical: 2),
      child: ElevatedButton(
        child: Text(this.buttonText),
        onPressed: this.answerAction,
      ),
    );
  }
}
