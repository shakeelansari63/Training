import 'package:flutter/material.dart';

// Import from current project
import './question.dart';
import './answers.dart';

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
      'answers': ['Red', 'Blue', 'Green', 'Yellow']
    },
    {
      'question': "What is your favourite Animal?",
      'answers': ['Rabbit', 'Cat', 'Dog', 'Hamster']
    },
    {
      'question': "What is your favourite Plant?",
      'answers': ['Rose', 'Lily', 'Tulsi', 'Neem']
    },
  ];
  // default poiter to point at 1st question
  var questionId = 0;

  // Implement Build method
  Widget build(BuildContext ctx) {
    // App Bar
    var appBar = AppBar(
      title: Text('QnA App'),
    );

    // Body of Scaffold
    // If questionid is less than all questions, we will display body which will increment question
    // Once all are done, we will display end message
    Widget body;
    if (this.questionId < this.questions.length) {
      body = Column(
        children: [
          Question(this.questions[this.questionId]['question']),
          // We map the answers and create a list then user spread operator to generate the list of answer buttons
          ...(this.questions[this.questionId]['answers'] as List).map((answer) {
            return Answer(answer, answerQuestion);
          })
        ],
      );
    } else {
      body = Center(
        child: Text(
          'Your Did It !!!!',
          textAlign: TextAlign.center,
          style: TextStyle(fontSize: 30),
        ),
      );
    }

    // Scaffold to wrap AppBar and Body
    var mainWin = Scaffold(appBar: appBar, body: body);

    return MaterialApp(home: mainWin);
  }

  // Method to handle Button Clicks
  void answerQuestion() {
    print('Got answer !!');
    // Not set the state so App knows we are changing state and
    setState(() {
      if (this.questionId < this.questions.length) {
        this.questionId += 1;
      }
    });
  }
}
