import 'package:flutter/material.dart';

// Our Question class to render questions on screen
class Question extends StatelessWidget {
  // Class property to hold questions
  // questionText is final since we don't want it to change as we are in stateless widget
  final String questionText;

  // Constructor to initialize questions
  Question(this.questionText);

  @override
  Widget build(BuildContext context) {
    // Formated Questions
    var ques = Text(
      this.questionText,
      style: TextStyle(fontSize: 25),
      textAlign: TextAlign.center,
    );

    // Lets return a container which takes full size of dispay
    // so our text looks in center
    return Container(
      child: ques,
      width: double.infinity,
      margin: EdgeInsets.all(10),
    );
  }
}
