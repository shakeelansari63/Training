import 'package:flutter/material.dart';

class Result extends StatelessWidget {
  final int totalScore;
  final Function restartQuiz;

  Result(this.totalScore, this.restartQuiz);

  @override
  Widget build(BuildContext context) {
    return Container(
      width: double.infinity,
      child: Column(
        children: [
          Text(
            'Your Did It !!!!\nYour final score: ${this.totalScore}',
            textAlign: TextAlign.center,
            style: TextStyle(fontSize: 30),
          ),
          TextButton(
            onPressed: this.restartQuiz,
            child: Text('Restart Quiz'),
            style: ButtonStyle(
              foregroundColor: MaterialStateProperty.all(Colors.red),
            ),
          ),
        ],
      ),
    );
  }
}
