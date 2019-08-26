import 'package:flutter/material.dart';
import './question.dart';
import './answer.dart';

// void main(){
//   runApp(MyApp());
// }

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return MyAppState();
  }
}
class MyAppState extends State<MyApp> {
    final qna = const [
    {
      'questionText' : 'What is color of your eye?',
      'answerOption' : [
        'Red', 'Black', 'Blue', 'Green'
      ]
    },
    {
      'questionText' : 'What is your favourite animal?',
      'answerOption' : [
        'Dog', 'Cat', 'Elephant', 'Horse'
      ]
    },
    {
      'questionText' : 'Who is your favouirite athlete?',
      'answerOption' : [
        'Nadal', 'Messi', 'Kohli', 'None'
      ]
    }
  ];
  
  var index = 0;

  void doNothing(){
    setState(() {
      if(index < qna.length){
        index += 1;
      }
    });
  }

  @override
  Widget build(BuildContext context){
      return MaterialApp(home: Scaffold(
      appBar: AppBar(title: Text('My First App'),),

      body: index < qna.length  ? Column(
        children: [
          Question(qna[index]['questionText']),
          ...(qna[index]['answerOption'] as List<String>).map((answer){
            return Answer(answer, doNothing);
          }).toList()

          //Answer((qna[index]['answerOption'] as List<String>)[0], doNothing),
          //Answer((qna[index]['answerOption'] as List<String>)[1], doNothing),
          //Answer((qna[index]['answerOption'] as List<String>)[2], doNothing),
          //Answer((qna[index]['answerOption'] as List<String>)[3], doNothing),
        ],
      ) : Center(
        child: Column(
          children: [
            Text('You have reached End. '),
            RaisedButton(
              child : Text('Start Again'),
              onPressed: () => {
                setState(() => index = 0)
              },
            )
          ]
        ),
      ),

      bottomNavigationBar: BottomAppBar(
        child: Row(
          children: [
            BackButton(),
            Text('Status Bar'),
            FlatButton(child: Text('Forward'), onPressed: () {
              print('Doing Nothing');
            },)
          ],
        ),
        ),
    ),);
  }
}