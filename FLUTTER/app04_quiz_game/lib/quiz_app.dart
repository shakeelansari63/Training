import 'package:app04_quiz_game/data/quiz_questions.dart';
import 'package:flutter/material.dart';
import 'package:app04_quiz_game/gradient_container.dart';
import 'package:app04_quiz_game/splash_screen.dart';
import 'package:app04_quiz_game/questions_screen.dart';

class QuizApp extends StatefulWidget {
  const QuizApp({super.key});

  @override
  State<QuizApp> createState() => _QuizAppState();
}

class _QuizAppState extends State<QuizApp> {
  List<String> selectedAnswers = [];
  var appScreenId = 'splash-screen';

  void changeScreen() {
    setState(() {
      appScreenId = 'question-screen';
    });
  }

  void recordAnswer(String answer) {
    selectedAnswers.add(answer);

    if (selectedAnswers.length == questions.length) {
      setState(() {
        selectedAnswers = [];
        appScreenId = 'splash-screen';
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    Widget appScreen;

    if (appScreenId == 'splash-screen') {
      appScreen = SplashScreen(changeScreen);
    } else {
      appScreen = QuestionScreen(onAnswerSelect: recordAnswer);
    }
    return MaterialApp(
      home: Scaffold(
        body: GradientContainer(appScreen),
      ),
    );
  }
}
