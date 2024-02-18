import 'package:app06_meals_app/models/meal.dart';
import 'package:app06_meals_app/providers/meal_provider.dart';
import 'package:app06_meals_app/screens/meals_screen.dart';
import 'package:app06_meals_app/widgets/category_item.dart';
import 'package:flutter/material.dart';
import 'package:app06_meals_app/models/category.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

class CategoriesScreen extends ConsumerWidget {
  const CategoriesScreen({super.key, required this.availableMeals});

  final List<Meal> availableMeals;

  void _selectCategory(BuildContext ctx, Category category) {
    Navigator.of(ctx).push(
      MaterialPageRoute(
        builder: (ctx) => MealsScreen(
          title: category.title,
          meals: availableMeals
              .where((meal) => meal.categories.contains(category.id))
              .toList(),
        ),
      ),
    );
  }

  // Widget ref is added to Build method to provide provider ref
  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final availableCategories = ref.read(categoryProvider);
    return GridView(
      padding: const EdgeInsets.all(24),
      gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
        crossAxisCount: 2,
        crossAxisSpacing: 20,
        mainAxisSpacing: 20,
      ),
      children: availableCategories
          .map((category) => CategoryItem(
                category: category,
                onCategorySelect: () => _selectCategory(context, category),
              ))
          .toList(),
    );
  }
}
