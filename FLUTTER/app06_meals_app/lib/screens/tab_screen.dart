import 'package:app06_meals_app/providers/favourites_provider.dart';
import 'package:app06_meals_app/providers/meal_provider.dart';
import 'package:app06_meals_app/screens/categories_screen.dart';
import 'package:app06_meals_app/screens/filters_screen.dart';
import 'package:app06_meals_app/screens/meals_screen.dart';
import 'package:app06_meals_app/widgets/main_drawer.dart';
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

final kInitMealFilter = MealFilters(
  glutenFree: false,
  lactoseFree: false,
  vegetarian: false,
  vegan: false,
);

class TabScreen extends ConsumerStatefulWidget {
  const TabScreen({super.key});

  @override
  ConsumerState<TabScreen> createState() => _TabScreenState();
}

class _TabScreenState extends ConsumerState<TabScreen> {
  int _selectedTab = 0;
  MealFilters _selectedFilters = kInitMealFilter;

  void tabChanged(int index) {
    setState(() {
      _selectedTab = index;
    });
  }

  void _selectDrawermenu(String id) async {
    Navigator.of(context).pop();
    if (id == 'filters') {
      final filters = await Navigator.of(context).push<MealFilters>(
        MaterialPageRoute(
          builder: (ctx) => FiltersScreen(
            currentFilters: _selectedFilters,
          ),
        ),
      );

      setState(() {
        _selectedFilters = filters!;
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    // Ref added automatically to read provider
    final availableMealsFromProvider = ref.watch(mealProvider);

    final favMeals = ref.watch(favouritesProvider);

    final availableMeals = availableMealsFromProvider.where((meal) {
      if (_selectedFilters.glutenFree && !meal.isGlutenFree) return false;
      if (_selectedFilters.lactoseFree && !meal.isLactoseFree) return false;
      if (_selectedFilters.vegetarian && !meal.isVegetarian) return false;
      if (_selectedFilters.vegan && !meal.isVegan) return false;
      return true;
    }).toList();

    Widget screen = CategoriesScreen(
      availableMeals: availableMeals,
    );
    String title = 'Categories';

    if (_selectedTab == 1) {
      screen = MealsScreen(meals: favMeals);
      title = 'Your Favorites';
    }

    return Scaffold(
      appBar: AppBar(
        title: Text(title),
      ),
      drawer: MainDrawer(
        onMenuSelected: _selectDrawermenu,
      ),
      body: screen,
      bottomNavigationBar: BottomNavigationBar(
        onTap: tabChanged,
        currentIndex: _selectedTab,
        items: const [
          BottomNavigationBarItem(
            icon: Icon(Icons.food_bank),
            label: 'Categories',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.favorite),
            label: 'Favourite',
          ),
        ],
      ),
    );
  }
}
