import 'package:flutter/material.dart';

class QuizApp extends StatefulWidget {
  const QuizApp({super.key});

  @override
  State<QuizApp> createState() => _QuizAppState();
}

class _QuizAppState extends State<QuizApp> {
  void startQuiz() {}

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisSize: MainAxisSize.min,
      children: [
        Image.asset('assets/quiz-logo.png'),
        const SizedBox(
          height: 100,
        ),
        OutlinedButton(
          onPressed: startQuiz,
          style: OutlinedButton.styleFrom(
              foregroundColor: Colors.white, padding: const EdgeInsets.all(20)),
          child: const Text('Start Quiz'),
        )
      ],
    );
  }
}
