import 'package:app04_quiz_game/answer_button.dart';
import 'package:flutter/material.dart';
import 'package:app04_quiz_game/data/quiz_questions.dart';
import 'package:google_fonts/google_fonts.dart';

class QuestionScreen extends StatefulWidget {
  const QuestionScreen({super.key, required this.onAnswerSelect});

  final Function(String answer) onAnswerSelect;

  @override
  State<QuestionScreen> createState() => _QuestionScreenState();
}

class _QuestionScreenState extends State<QuestionScreen> {
  var questionIndex = 0;

  void answerChosen(String answer) {
    widget.onAnswerSelect(answer);

    setState(() {
      questionIndex++;
    });
  }

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
            style: GoogleFonts.lato(
              color: Colors.white,
              fontSize: 20,
              fontWeight: FontWeight.bold,
            ),
            textAlign: TextAlign.center,
          ),
          const SizedBox(
            height: 20,
          ),
          ...questions[questionIndex]
              .getShuffledAnswers()
              .map((answer) => AnswerButton(
                    action: () => answerChosen(answer),
                    text: answer,
                  )),
        ],
      ),
    );
  }
}
