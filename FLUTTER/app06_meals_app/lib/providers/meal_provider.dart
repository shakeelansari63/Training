import 'package:app06_meals_app/data/dummy_data.dart';
import 'package:app06_meals_app/models/category.dart';
import 'package:app06_meals_app/models/meal.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

// Static Providers

// Return List of Meals
final mealProvider = Provider<List<Meal>>((ref) {
  return dummyMeals;
});

// Return List of Categories
final categoryProvider = Provider<List<Category>>((ref) => availableCategories);
