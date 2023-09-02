import 'package:app05_expense_tracker/models/expense.dart';
import 'package:app05_expense_tracker/widgets/expense_list/expense_item.dart';
import 'package:flutter/material.dart';

class ExpenseList extends StatelessWidget {
  const ExpenseList(
      {super.key, required this.expenses, required this.onRemoveExpense});

  final List<Expense> expenses;
  final void Function(Expense expense) onRemoveExpense;

  Widget expenseViewBuilder(BuildContext ctx, int idx) {
    return Dismissible(
      key: ValueKey(expenses[idx]),
      onDismissed: (direction) {
        onRemoveExpense(expenses[idx]);
      },
      child: ExpenseItem(expense: expenses[idx]),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Expanded(
      child: ListView.builder(
        itemCount: expenses.length,
        itemBuilder: expenseViewBuilder,
      ),
    );
  }
}
