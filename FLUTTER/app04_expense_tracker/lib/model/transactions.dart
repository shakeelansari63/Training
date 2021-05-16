import 'package:flutter/foundation.dart';

class Transaction {
  String id;
  String title;
  double amt;
  DateTime expenseDt;

  Transaction(
      {@required String title,
      @required double amt,
      @required DateTime expenseDt}) {
    this.title = title;
    this.amt = amt;
    this.expenseDt = expenseDt;
    this.id = expenseDt.toString() + title + amt.toString();
  }
}
