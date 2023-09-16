import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

final theme = ThemeData(
  colorScheme: ColorScheme.fromSeed(
    brightness: Brightness.dark,
    seedColor: const Color.fromARGB(255, 59, 0, 0),
  ),
  useMaterial3: true,
  textTheme: GoogleFonts.latoTextTheme(),
);
