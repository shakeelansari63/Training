import 'package:flutter/material.dart';

import './widgets/user_transaction.dart';

// main
void main() => runApp(ExpenseTracker());

class ExpenseTracker extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    var mainBody = Column(
      children: [
        Card(
          child: Container(
            width: double.infinity,
            child: Text('Chart'),
          ),
          elevation: 5,
        ),
        UserTransactions(),
      ],
    );

    var mainWin = Scaffold(
      appBar: AppBar(
        title: Text('Expense Tracker'),
      ),
      body: mainBody,
    );

    // return material app
    return MaterialApp(home: mainWin);
  }
}
