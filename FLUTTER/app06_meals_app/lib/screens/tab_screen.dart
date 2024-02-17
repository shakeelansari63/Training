import 'package:app06_meals_app/data/dummy_data.dart';
import 'package:app06_meals_app/screens/categories_screen.dart';
import 'package:app06_meals_app/screens/filters_screen.dart';
import 'package:app06_meals_app/screens/meals_screen.dart';
import 'package:app06_meals_app/widgets/main_drawer.dart';
import 'package:flutter/material.dart';

final kInitMealFilter = MealFilters(
  glutenFree: false,
  lactoseFree: false,
  vegetarian: false,
  vegan: false,
);

class TabScreen extends StatefulWidget {
  const TabScreen({super.key});

  @override
  State<TabScreen> createState() => _TabScreenState();
}

class _TabScreenState extends State<TabScreen> {
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
    final availableMeals = dummyMeals.where((meal) {
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
      screen = const MealsScreen(meals: []);
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
