import 'package:app05_expense_tracker/models/expense.dart';
import 'package:app05_expense_tracker/widgets/add_expense.dart';
import 'package:app05_expense_tracker/widgets/chart/charts.dart';
import 'package:app05_expense_tracker/widgets/expense_list/expense_list.dart';
import 'package:flutter/material.dart';

class ExpenseTracker extends StatefulWidget {
  const ExpenseTracker({super.key, required this.onThemeChange});

  final void Function() onThemeChange;

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
    final expensePosition = data.indexOf(expense);
    setState(() {
      data.remove(expense);
    });

    // Clear any previous Snackbars
    ScaffoldMessenger.of(context).clearSnackBars();

    // Show Snack Bar after removing Expense
    ScaffoldMessenger.of(context).showSnackBar(SnackBar(
      duration: const Duration(seconds: 2),
      content: const Text('Expense Removed'),
      action: SnackBarAction(
        label: 'Undo',
        onPressed: () {
          setState(() {
            data.insert(expensePosition, expense);
          });
        },
      ),
    ));
  }

  @override
  Widget build(BuildContext context) {
    Widget expenseWidget = const Center(
      child: Text("No Expenses found. Add some by clicking '+' on top"),
    );

    if (data.isNotEmpty) {
      expenseWidget = ExpenseList(
        expenses: data,
        onRemoveExpense: _removeExpense,
      );
    }

    return Scaffold(
      appBar: AppBar(
        title: const Text('Expense Tracker'),
        actions: [
          IconButton(
            onPressed: _showNewExpense,
            icon: const Icon(Icons.add),
          ),
          IconButton(
            onPressed: widget.onThemeChange,
            icon: const Icon(Icons.brightness_6_outlined),
          ),
        ],
      ),
      body: Center(
        child: Column(
          children: [
            Chart(
              expenses: data,
            ),
            Expanded(
              child: expenseWidget,
            ),
          ],
        ),
      ),
    );
  }
}
