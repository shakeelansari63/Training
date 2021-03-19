import 'package:flutter/material.dart';

import './question.dart';
import './answers.dart';

class Quiz extends StatelessWidget {
  final List questions;
  final int questionId;
  final Function answerQuestion;

  // Constructor to qaccept values
  Quiz(
      {@required this.questions,
      @required this.questionId,
      @required this.answerQuestion});

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Question(this.questions[this.questionId]['question']),
        // We map the answers and create a list then user spread operator to generate the list of answer buttons
        ...(this.questions[this.questionId]['answers']
                as List<Map<String, Object>>)
            .map((answer) {
          return Answer(answer['text'], () => answerQuestion(answer['score']));
        })
      ],
    );
  }
}
