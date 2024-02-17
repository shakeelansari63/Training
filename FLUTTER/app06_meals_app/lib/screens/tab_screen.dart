import 'package:app06_meals_app/screens/categories_screen.dart';
import 'package:app06_meals_app/screens/meals_screen.dart';
import 'package:flutter/material.dart';

class TabScreen extends StatefulWidget {
  const TabScreen({super.key});

  @override
  State<TabScreen> createState() => _TabScreenState();
}

class _TabScreenState extends State<TabScreen> {
  int _selectedTab = 0;

  void tabChanged(int index) {
    setState(() {
      _selectedTab = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    Widget screen = const CategoriesScreen();
    String title = 'Categories';

    if (_selectedTab == 1) {
      screen = const MealsScreen(meals: []);
      title = 'Your Favorites';
    }

    return Scaffold(
      appBar: AppBar(
        title: Text(title),
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
