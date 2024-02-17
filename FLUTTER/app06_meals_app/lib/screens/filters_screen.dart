import 'package:flutter/material.dart';

class MealFilters {
  MealFilters({
    required this.glutenFree,
    required this.lactoseFree,
    required this.vegetarian,
    required this.vegan,
  });

  bool glutenFree;
  bool lactoseFree;
  bool vegetarian;
  bool vegan;
}

class FiltersScreen extends StatefulWidget {
  const FiltersScreen({super.key, required this.currentFilters});

  final MealFilters currentFilters;

  @override
  State<FiltersScreen> createState() => _FiltersScreenState();
}

class _FiltersScreenState extends State<FiltersScreen> {
  // Filter values
  bool _lactoseFree = false;
  bool _glutenFree = false;
  bool _vegetarian = false;
  bool _vegan = false;

  @override
  void initState() {
    super.initState();

    // Initialize filters
    _glutenFree = widget.currentFilters.glutenFree;
    _lactoseFree = widget.currentFilters.lactoseFree;
    _vegetarian = widget.currentFilters.vegetarian;
    _vegan = widget.currentFilters.vegan;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Filters'),
      ),
      body: PopScope(
        canPop: false, // Avoid double popping since we pop manually
        onPopInvoked: (bool didPop) {
          if (didPop) return;
          // return map with pop
          Navigator.of(context).pop(MealFilters(
            glutenFree: _glutenFree,
            lactoseFree: _lactoseFree,
            vegetarian: _vegetarian,
            vegan: _vegan,
          ));
        },
        child: Column(
          children: [
            SwitchListTile(
              value: _lactoseFree,
              onChanged: (isChecked) {
                setState(() {
                  _lactoseFree = isChecked;
                });
              },
              title: Text(
                'Lactose Free',
                style: Theme.of(context).textTheme.titleLarge!.copyWith(
                    color: Theme.of(context).colorScheme.onBackground),
              ),
              subtitle: Text(
                'Filter only lactose free meal',
                style: Theme.of(context).textTheme.labelMedium!.copyWith(
                    color: Theme.of(context).colorScheme.onBackground),
              ),
            ),
            SwitchListTile(
              value: _glutenFree,
              onChanged: (isChecked) {
                setState(() {
                  _glutenFree = isChecked;
                });
              },
              title: Text(
                'Gluten Free',
                style: Theme.of(context).textTheme.titleLarge!.copyWith(
                    color: Theme.of(context).colorScheme.onBackground),
              ),
              subtitle: Text(
                'Filter only gluten free meal',
                style: Theme.of(context).textTheme.labelMedium!.copyWith(
                    color: Theme.of(context).colorScheme.onBackground),
              ),
            ),
            SwitchListTile(
              value: _vegetarian,
              onChanged: (isChecked) {
                setState(() {
                  _vegetarian = isChecked;
                });
              },
              title: Text(
                'Vegetarian',
                style: Theme.of(context).textTheme.titleLarge!.copyWith(
                    color: Theme.of(context).colorScheme.onBackground),
              ),
              subtitle: Text(
                'Filter only vegetarian meal',
                style: Theme.of(context).textTheme.labelMedium!.copyWith(
                    color: Theme.of(context).colorScheme.onBackground),
              ),
            ),
            SwitchListTile(
              value: _vegan,
              onChanged: (isChecked) {
                setState(() {
                  _vegan = isChecked;
                });
              },
              title: Text(
                'Vegan',
                style: Theme.of(context).textTheme.titleLarge!.copyWith(
                    color: Theme.of(context).colorScheme.onBackground),
              ),
              subtitle: Text(
                'Filter only vegan meal',
                style: Theme.of(context).textTheme.labelMedium!.copyWith(
                    color: Theme.of(context).colorScheme.onBackground),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
