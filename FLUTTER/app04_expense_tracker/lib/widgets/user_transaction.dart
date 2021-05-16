import 'package:flutter/material.dart';

import './new_transaction.dart';
import './transaction_card.dart';
import '../model/transactions.dart';

class UserTransactions extends StatefulWidget {
  @override
  _UserTransactionsState createState() => _UserTransactionsState();
}

class _UserTransactionsState extends State<UserTransactions> {
  // Transactions
  final List<Transaction> trans = [
    Transaction(title: "New Shoes", amt: 329, expenseDt: DateTime.now()),
    Transaction(title: "New Shirt", amt: 599, expenseDt: DateTime.now()),
    Transaction(title: "New Jeans", amt: 1299, expenseDt: DateTime.now()),
  ];

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        NewTransaction(),
        ListTransaction(trans),
      ],
    );
  }
}
