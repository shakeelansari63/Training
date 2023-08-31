import 'package:flutter/material.dart';

class GradientContainer extends StatelessWidget {
  const GradientContainer(this.appScreen, {super.key});

  final Widget appScreen;
  final colorStart = const Color.fromARGB(255, 33, 5, 109);
  final colorEnd = const Color.fromARGB(255, 68, 21, 149);

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        gradient: LinearGradient(
          begin: Alignment.topLeft,
          end: Alignment.bottomRight,
          colors: [colorStart, colorEnd],
        ),
      ),
      child: appScreen,
    );
  }
}
