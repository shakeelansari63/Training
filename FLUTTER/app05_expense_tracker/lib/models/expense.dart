import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import 'package:uuid/uuid.dart';

const uuid = Uuid();
final dateFormatter = DateFormat.yMMMd();

enum Category {
  food,
  travel,
  leisure,
  work,
}

final categoryIcon = {
  Category.food: Icons.lunch_dining,
  Category.travel: Icons.flight_takeoff,
  Category.leisure: Icons.movie,
  Category.work: Icons.work,
};

class Expense {
  Expense({
    required this.title,
    required this.amount,
    required this.category,
    required this.date,
  }) : id = uuid.v4();
  final String id;
  final String title;
  final double amount;
  final Category category;
  final DateTime date;

  // Getter for formatted date
  String get formattedDate {
    return dateFormatter.format(date);
  }
}

class ExpenseBucket {
  ExpenseBucket({
    required this.category,
    required this.expenses,
  });

  ExpenseBucket.fromCategory(
    List<Expense> allExpenses, {
    required this.category,
  }) : expenses = allExpenses
            .where((expense) => expense.category == category)
            .toList();

  Category category;
  List<Expense> expenses;

  double get bucketValue {
    double sum = 0;

    for (final expense in expenses) {
      sum += expense.amount;
    }

    return sum;
  }
}
