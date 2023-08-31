import 'package:app04_quiz_game/answer_button.dart';
import 'package:flutter/material.dart';
import 'package:app04_quiz_game/data/quiz_questions.dart';

class QuestionScreen extends StatefulWidget {
  const QuestionScreen({super.key});

  @override
  State<QuestionScreen> createState() => _QuestionScreenState();
}

class _QuestionScreenState extends State<QuestionScreen> {
  final questionIndex = 0;

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: const EdgeInsets.all(40),
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        crossAxisAlignment: CrossAxisAlignment.stretch,
        children: [
          Text(
            questions[questionIndex].question,
            style: const TextStyle(
              color: Colors.white,
            ),
            textAlign: TextAlign.center,
          ),
          const SizedBox(
            height: 20,
          ),
          ...questions[questionIndex]
              .getShuffledAnswers()
              .map((answer) => AnswerButton(
                    action: () {},
                    text: answer,
                  ))
        ],
      ),
    );
  }
}
