import 'package:flutter/material.dart';

class ChartBar extends StatelessWidget {
  const ChartBar(this.heightFraction, {super.key});

  final double heightFraction;

  @override
  Widget build(BuildContext context) {
    return Expanded(
      child: SizedBox(
        width: 40,
        child: Padding(
          padding: const EdgeInsets.all(4),
          child: FractionallySizedBox(
            heightFactor: heightFraction,
            alignment: Alignment.bottomCenter,
            child: DecoratedBox(
              decoration: BoxDecoration(
                shape: BoxShape.rectangle,
                color: Theme.of(context).colorScheme.secondary,
                borderRadius: const BorderRadius.vertical(
                  top: Radius.circular(5),
                ),
              ),
            ),
          ),
        ),
      ),
    );
  }
}
