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
  var appScreenId = 'splash-screen';

  void changeScreen() {
    setState(() {
      appScreenId = 'question-screen';
    });
  }

  @override
  Widget build(BuildContext context) {
    Widget appScreen;

    if (appScreenId == 'splash-screen') {
      appScreen = SplashScreen(changeScreen);
    } else {
      appScreen = const QuestionScreen();
    }
    return MaterialApp(
      home: Scaffold(
        body: GradientContainer(appScreen),
      ),
    );
  }
}
