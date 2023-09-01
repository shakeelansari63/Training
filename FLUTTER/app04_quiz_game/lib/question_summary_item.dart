import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class QuestionSummaryItem extends StatelessWidget {
  const QuestionSummaryItem(this.summaryItem, {super.key});
  final Map<String, Object> summaryItem;

  @override
  Widget build(BuildContext context) {
    final isAnswerCorrect =
        summaryItem['correct_answer'] == summaryItem['user_answer'];

    return Row(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Icon(
          isAnswerCorrect
              ? Icons.check_circle_outline
              : Icons.error_outline_outlined,
          color: isAnswerCorrect ? Colors.green[600] : Colors.red[300],
          size: 28,
        ),
        Expanded(
          child: Padding(
            padding: const EdgeInsets.symmetric(horizontal: 10),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  summaryItem['question'] as String,
                  style: GoogleFonts.lato(
                    color: Colors.white,
                    fontSize: 16,
                  ),
                ),
                const SizedBox(
                  height: 5,
                ),
                Text(
                  summaryItem['user_answer'] as String,
                  style: TextStyle(
                    color:
                        isAnswerCorrect ? Colors.green[600] : Colors.red[300],
                  ),
                ),
                const SizedBox(
                  height: 5,
                ),
                Text(
                  summaryItem['correct_answer'] as String,
                  style: TextStyle(
                    color: Colors.green[600],
                  ),
                ),
                const SizedBox(
                  height: 10,
                ),
              ],
            ),
          ),
        )
      ],
    );
  }
}
