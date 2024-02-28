import 'package:app06_meals_app/models/meal.dart';
import 'package:app06_meals_app/providers/meal_provider.dart';
import 'package:app06_meals_app/screens/meals_screen.dart';
import 'package:app06_meals_app/widgets/category_item.dart';
import 'package:flutter/material.dart';
import 'package:app06_meals_app/models/category.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

class CategoriesScreen extends ConsumerStatefulWidget {
  const CategoriesScreen({super.key, required this.availableMeals});

  final List<Meal> availableMeals;

  @override
  ConsumerState<CategoriesScreen> createState() => _CategoriesScreenState();
}

// Animation will be added to State Class, thats why this is StateFullWidget
// Also Inherit the SingleTickerProvider to provider internal ticker
class _CategoriesScreenState extends ConsumerState<CategoriesScreen>
    with SingleTickerProviderStateMixin {
  // This animation controller is late to tell that this won't be ste immediately, but will be set eventually
  late AnimationController _gridAnimationController;

  // We need to set and start animation on InitState
  // And dispose animation controller manually on dispose

  @override
  void initState() {
    super.initState();

    // Set Animation Controller
    _gridAnimationController = AnimationController(
      vsync: this, // This as we have inherited from SingleTickerProvider
      duration: const Duration(milliseconds: 300), // Run aimation for 300ms
      lowerBound: 0,
      upperBound: 1,
    );

    // Now we have animation controller, we can run animation
    _gridAnimationController.forward();
  }

  void _selectCategory(BuildContext ctx, Category category) {
    Navigator.of(ctx).push(
      MaterialPageRoute(
        builder: (ctx) => MealsScreen(
          title: category.title,
          meals: widget.availableMeals
              .where((meal) => meal.categories.contains(category.id))
              .toList(),
        ),
      ),
    );
  }

  // Widget ref is added to Build method to provide provider ref
  @override
  Widget build(BuildContext context) {
    final availableCategories = ref.read(categoryProvider);
    return AnimatedBuilder(
      // We use Animated builder to build animation
      animation: _gridAnimationController, // Controller
      child: GridView(
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
      ),
      // This builder method runs animation, and child will be loaded once
      // And can be animated for efficiency
      builder: (context, child) => SlideTransition(
        position: Tween(
          begin: const Offset(0, 0.3),
          end: const Offset(0, 0),
        ).animate(
          CurvedAnimation(
            parent: _gridAnimationController,
            curve: Curves.easeInQuart,
          ),
        ),
        child: child, // This child will slide with Slide Transition
      ),
    );
  }
}
