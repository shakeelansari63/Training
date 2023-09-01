import 'package:app04_quiz_game/data/quiz_questions.dart';
import 'package:app04_quiz_game/questions_summary.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class ResultScreen extends StatelessWidget {
  const ResultScreen(this.selectedAnswers,
      {super.key, required this.onQuizRestart});

  final List<String> selectedAnswers;
  final void Function() onQuizRestart;

  List<Map<String, Object>> getSummary() {
    List<Map<String, Object>> summary = [];

    // Generate the Summary
    for (var i = 0; i < selectedAnswers.length; i++) {
      summary.add({
        'question_idx': i,
        'question': questions[i].question,
        'correct_answer': questions[i].answers[0],
        'user_answer': selectedAnswers[i]
      });
    }

    return summary;
  }

  @override
  Widget build(BuildContext context) {
    final summary = getSummary();
    final numberQuestions = questions.length;
    final correctQuestions = summary
        .where(
            (question) => question['correct_answer'] == question['user_answer'])
        .length;

    return SizedBox(
      width: double.infinity,
      child: Container(
        margin: const EdgeInsets.all(20),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              'You answered $correctQuestions out of $numberQuestions questions correctly',
              style: GoogleFonts.lato(
                color: Colors.white,
                fontSize: 20,
                fontWeight: FontWeight.w700,
              ),
              textAlign: TextAlign.center,
            ),
            const SizedBox(
              height: 30,
            ),
            QuestionSummary(summary),
            const SizedBox(
              height: 30,
            ),
            TextButton.icon(
              onPressed: onQuizRestart,
              icon: const Icon(Icons.restart_alt_sharp, color: Colors.white),
              label: const Text(
                'Restart Quiz',
                style: TextStyle(
                  color: Colors.white,
                ),
              ),
            )
          ],
        ),
      ),
    );
  }
}
