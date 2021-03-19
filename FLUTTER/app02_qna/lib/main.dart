import 'package:flutter/material.dart';

// Import from current project
import './quiz.dart';
import './result.dart';

void main() => runApp(QnA());

// In order to change data on the fly, we will use Stateful widget
// Stateful widget need another class i.e. State and create state on that
class QnA extends StatefulWidget {
  // Override the CreateState method of StatefulWidget and return the instance of State
  @override
  State createState() => _QnAState();
}

// This is private class which can only be used here and cannot be exported
class _QnAState extends State {
  // Questions to be asked
  final questions = const [
    {
      'question': "What is your favourite Color?",
      'answers': [
        {'text': 'Red', 'score': 10},
        {'text': 'Blue', 'score': 8},
        {'text': 'Green', 'score': 5},
        {'text': 'Yellow', 'score': 2}
      ]
    },
    {
      'question': "What is your favourite Animal?",
      'answers': [
        {'text': 'Rabbit', 'score': 8},
        {'text': 'Cat', 'score': 5},
        {'text': 'Dog', 'score': 10},
        {'text': 'Hamster', 'score': 2}
      ]
    },
    {
      'question': "What is your favourite Plant?",
      'answers': [
        {'text': 'Rose', 'score': 10},
        {'text': 'Lily', 'score': 5},
        {'text': 'Tulsi', 'score': 2},
        {'text': 'Neem', 'score': 8}
      ]
    },
  ];
  // default poiter to point at 1st question
  var questionId = 0;

  // Final Score
  var finalScore = 0;

  // Implement Build method
  Widget build(BuildContext ctx) {
    // App Bar
    var appBar = AppBar(
      title: Text('QnA App'),
    );

    // Body of Scaffold
    // If questionid is less than all questions, we will display body which will increment question
    // Once all are done, we will display end message
    var body = this.questionId < this.questions.length
        ? Quiz(
            questions: questions,
            questionId: questionId,
            answerQuestion: answerQuestion)
        : Result(this.finalScore, restartQuiz);

    // Scaffold to wrap AppBar and Body
    var mainWin = Scaffold(appBar: appBar, body: body);

    return MaterialApp(home: mainWin);
  }

  // Method to handle Button Clicks
  void answerQuestion(int score) {
    print('Got answer !!');
    // Not set the state so App knows we are changing state and
    setState(() {
      if (this.questionId < this.questions.length) {
        this.questionId += 1;
        this.finalScore += score;
        print("Total Score ${this.finalScore}");
      }
    });
  } // answer Quiz function

  void restartQuiz() {
    print('Restarting Quiz!!!');

    setState(() {
      this.finalScore = 0;
      this.questionId = 0;
    });
  } // restart Quiz function
}
