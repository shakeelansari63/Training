import 'package:app05_expense_tracker/expense_tracker.dart';
import 'package:app05_expense_tracker/theme.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  var currentTheme = ThemeMode.light;

  void _changeTheme() {
    setState(() {
      currentTheme =
          currentTheme == ThemeMode.light ? ThemeMode.dark : ThemeMode.light;
    });
  }

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Expense Tracker',
      theme: lightTheme,
      darkTheme: darkTheme,
      themeMode: currentTheme,
      home: ExpenseTracker(onThemeChange: _changeTheme),
    );
  }
}
