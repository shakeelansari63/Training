import 'package:flutter/material.dart';

final lightColorScheme = ColorScheme.fromSeed(
  seedColor: Colors.orange,
);

final darkColorScheme = ColorScheme.fromSeed(
  brightness: Brightness.dark,
  seedColor: Colors.orange,
);

final lightTheme = ThemeData().copyWith(
  useMaterial3: true,
  colorScheme: lightColorScheme,
  elevatedButtonTheme: getElevatedButtonStyle(lightColorScheme),
  cardTheme: getCardTheme(lightColorScheme),
  appBarTheme: getAppBarTheme(lightColorScheme),
);

final darkTheme = ThemeData.dark().copyWith(
  useMaterial3: true,
  colorScheme: darkColorScheme,
  elevatedButtonTheme: getElevatedButtonStyle(darkColorScheme),
  cardTheme: getCardTheme(darkColorScheme),
  appBarTheme: getAppBarTheme(darkColorScheme),
);

ElevatedButtonThemeData getElevatedButtonStyle(ColorScheme colorScheme) {
  return ElevatedButtonThemeData(
    style: ElevatedButton.styleFrom(
      backgroundColor: colorScheme.primaryContainer,
      foregroundColor: colorScheme.onPrimaryContainer,
    ),
  );
}

CardTheme getCardTheme(ColorScheme colorScheme) {
  return const CardTheme().copyWith(
    color: colorScheme.secondaryContainer,
    margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
  );
}

AppBarTheme getAppBarTheme(ColorScheme colorScheme) {
  return const AppBarTheme().copyWith(
      backgroundColor: colorScheme.primaryContainer,
      foregroundColor: colorScheme.onPrimaryContainer);
}
