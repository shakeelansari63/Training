import 'package:app04_quiz_game/quiz_app.dart';
import 'package:flutter/material.dart';

class GradientContainer extends StatelessWidget {
  const GradientContainer({super.key});

  final colorStart = const Color.fromARGB(255, 33, 5, 109);
  final colorEnd = const Color.fromARGB(255, 68, 21, 149);

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        gradient: LinearGradient(
          begin: Alignment.topLeft,
          end: Alignment.bottomRight,
          colors: [colorStart, colorEnd],
        ),
      ),
      child: const Center(
        child: QuizApp(),
      ),
    );
  }
}
