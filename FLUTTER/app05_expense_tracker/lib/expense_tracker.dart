import 'package:app05_expense_tracker/models/expense.dart';
import 'package:app05_expense_tracker/widgets/add_expense.dart';
import 'package:app05_expense_tracker/widgets/expense_list/expense_list.dart';
import 'package:flutter/material.dart';

class ExpenseTracker extends StatefulWidget {
  const ExpenseTracker({super.key});

  @override
  State<ExpenseTracker> createState() => _ExpenseTrackerState();
}

class _ExpenseTrackerState extends State<ExpenseTracker> {
  final data = [
    Expense(
      title: 'Flutter Tutorial',
      amount: 200,
      category: Category.work,
      date: DateTime.now(),
    ),
    Expense(
      title: 'Jawaan Movie',
      amount: 150,
      category: Category.leisure,
      date: DateTime.now(),
    ),
    Expense(
      title: 'Mc Donalds',
      amount: 300,
      category: Category.food,
      date: DateTime.now(),
    ),
  ];

  void _showNewExpense() {
    showModalBottomSheet(
      isScrollControlled: true,
      context: context,
      builder: (ctx) {
        return AddExpense(
          onAddExpense: _addExpense,
        );
      },
    );
  }

  void _addExpense(Expense expense) {
    setState(() {
      data.add(expense);
    });
  }

  void _removeExpense(Expense expense) {
    setState(() {
      data.remove(expense);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Expense Tracker'),
        actions: [
          IconButton(onPressed: _showNewExpense, icon: const Icon(Icons.add)),
        ],
      ),
      body: Center(
        child: Column(
          children: [
            const Text('Chart Goes Here...'),
            ExpenseList(
              expenses: data,
              onRemoveExpense: _removeExpense,
            ),
          ],
        ),
      ),
    );
  }
}
