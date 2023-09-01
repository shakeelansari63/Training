import 'package:app04_quiz_game/question_summary_item.dart';
import 'package:flutter/material.dart';

class QuestionSummary extends StatelessWidget {
  const QuestionSummary(this.summary, {super.key});
  final List<Map<String, Object>> summary;

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      height: 400,
      child: SingleChildScrollView(
        child: Column(
          children: summary
              .map((summaryItem) => QuestionSummaryItem(summaryItem))
              .toList(),
        ),
      ),
    );
  }
}
