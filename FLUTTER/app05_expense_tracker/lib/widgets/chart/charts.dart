import 'package:app05_expense_tracker/models/expense.dart';
import 'package:app05_expense_tracker/widgets/chart/chart_bar.dart';
import 'package:flutter/material.dart';

class Chart extends StatelessWidget {
  const Chart({super.key, required this.expenses});

  final List<Expense> expenses;

  List<ExpenseBucket> get buckets {
    return [
      ExpenseBucket.fromCategory(expenses, category: Category.food),
      ExpenseBucket.fromCategory(expenses, category: Category.leisure),
      ExpenseBucket.fromCategory(expenses, category: Category.travel),
      ExpenseBucket.fromCategory(expenses, category: Category.work),
    ];
  }

  double get maxBucketValue {
    double maxValue = 0;

    for (final bucket in buckets) {
      if (bucket.bucketValue > maxValue) maxValue = bucket.bucketValue;
    }

    return maxValue;
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 250,
      width: double.infinity,
      margin: Theme.of(context).cardTheme.margin,
      decoration: BoxDecoration(
          borderRadius: BorderRadius.circular(8),
          gradient: LinearGradient(
            colors: [
              Theme.of(context).cardTheme.color!.withOpacity(1),
              Theme.of(context).cardTheme.color!.withOpacity(0.4),
            ],
            begin: Alignment.bottomCenter,
            end: Alignment.topCenter,
          )),
      child: Padding(
        padding: const EdgeInsets.all(10),
        child: Row(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          children: buckets
              .map((bucket) => Column(
                    mainAxisAlignment: MainAxisAlignment.end,
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: [
                      ChartBar(maxBucketValue == 0
                          ? 0
                          : bucket.bucketValue / maxBucketValue),
                      Icon(categoryIcon[bucket.category]),
                    ],
                  ))
              .toList(),
        ),
      ),
    );
  }
}
