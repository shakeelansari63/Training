import 'package:app06_meals_app/data/dummy_data.dart';
import 'package:app06_meals_app/models/meal.dart';
import 'package:app06_meals_app/screens/meals_screen.dart';
import 'package:app06_meals_app/widgets/category_item.dart';
import 'package:flutter/material.dart';
import 'package:app06_meals_app/models/category.dart';

class CategoriesScreen extends StatelessWidget {
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

  @override
  Widget build(BuildContext context) {
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
