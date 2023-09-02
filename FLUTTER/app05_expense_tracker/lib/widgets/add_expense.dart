import 'package:app05_expense_tracker/models/expense.dart';
import 'package:flutter/material.dart';

class AddExpense extends StatefulWidget {
  const AddExpense({super.key, required this.onAddExpense});
  final void Function(Expense expense) onAddExpense;

  @override
  State<AddExpense> createState() => _AddExpenseState();
}

class _AddExpenseState extends State<AddExpense> {
  final _titleController = TextEditingController();
  final _amountController = TextEditingController();
  Category _selectedCategory = Category.leisure;
  DateTime? _selectedDate;

  void _showDatePicker() async {
    final today = DateTime.now();
    final startDate = DateTime(today.year - 1, today.month, today.day);

    var datePicked = await showDatePicker(
        context: context,
        initialDate: today,
        firstDate: startDate,
        lastDate: today);

    setState(() {
      _selectedDate = datePicked;
    });
  }

  String get formattedSelectedDate {
    return dateFormatter.format(_selectedDate!);
  }

  void _saveExpense() {
    final enteredAmount = double.tryParse(_amountController.text);
    final amountInValid = enteredAmount == null || enteredAmount <= 0;
    if (amountInValid ||
        _titleController.text.trim().isEmpty ||
        _selectedDate == null) {
      // Show Alert
      showDialog(
        context: context,
        builder: (ctx) => AlertDialog(
          title: const Text('Invalid Input'),
          content: const Text(
              'Please check valid values are entered for Title, Amount and Date'),
          actions: [
            TextButton(
              onPressed: () {
                Navigator.pop(ctx);
              },
              child: const Text('OK'),
            ),
          ],
        ),
      );

      // Return now so we don't perocess any further
      return;
    }

    // If all inputs are valid then save expesne and close dialog
    widget.onAddExpense(Expense(
      title: _titleController.text,
      amount: enteredAmount,
      category: _selectedCategory,
      date: _selectedDate!,
    ));

    Navigator.pop(context);
  }

  // Dispose or Destructor to remove dangling controllers
  @override
  void dispose() {
    _titleController.dispose();
    _amountController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.fromLTRB(16, 48, 16, 16),
      child: Column(
        children: [
          TextField(
            controller: _titleController,
            maxLength: 20,
            decoration: const InputDecoration(
              label: Text('Title'),
            ),
          ),
          Row(
            children: [
              Expanded(
                child: TextField(
                  controller: _amountController,
                  keyboardType: TextInputType.number,
                  decoration: const InputDecoration(
                    label: Text('Amount'),
                    prefixText: '\$ ',
                  ),
                ),
              ),
              Expanded(
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.end,
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    Text(_selectedDate == null
                        ? 'Select a Date'
                        : formattedSelectedDate),
                    IconButton(
                      onPressed: _showDatePicker,
                      icon: const Icon(Icons.calendar_month),
                    )
                  ],
                ),
              )
            ],
          ),
          const SizedBox(
            height: 20,
          ),
          Row(
            children: [
              DropdownButton(
                value: _selectedCategory,
                items: Category.values
                    .map((category) => DropdownMenuItem(
                          value: category,
                          child: Text(category.name.toUpperCase()),
                        ))
                    .toList(),
                onChanged: (value) {
                  if (value == null) return;
                  setState(() {
                    _selectedCategory = value;
                  });
                },
              ),
              const Spacer(),
              TextButton(
                onPressed: () {
                  Navigator.pop(context);
                },
                child: const Text('Cancel'),
              ),
              const SizedBox(
                width: 5,
              ),
              ElevatedButton(
                onPressed: _saveExpense,
                child: const Text('Save'),
              ),
            ],
          ),
        ],
      ),
    );
  }
}
