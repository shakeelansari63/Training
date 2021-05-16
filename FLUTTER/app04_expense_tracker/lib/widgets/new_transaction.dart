import 'package:flutter/material.dart';

class NewTransaction extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _NewTransactionState();
  }
}

class _NewTransactionState extends State {
  final titleController = TextEditingController();
  final amtController = TextEditingController();

  void saveTransaction() {
    print(titleController.text);
    print(amtController.text);

    setState(() {
      amtController.text = '';
      titleController.text = '';
    });
  }

  @override
  Widget build(BuildContext context) {
    return Card(
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.end,
        children: [
          TextField(
            controller: titleController,
            decoration: InputDecoration(
              labelText: 'Title',
            ),
          ),
          TextField(
            controller: amtController,
            decoration: InputDecoration(labelText: 'Amount'),
          ),
          TextButton(
            onPressed: saveTransaction,
            child: Text('Save Transaction'),
            style: ButtonStyle(
              foregroundColor: MaterialStateProperty.all(Colors.purple),
            ),
          ),
        ],
      ),
    );
  }
}
