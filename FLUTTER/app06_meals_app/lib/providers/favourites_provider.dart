import 'package:app06_meals_app/models/meal.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

class FavouriteMealNotifier extends StateNotifier<List<Meal>> {
  // Constructor which initialize initial state value in parent class
  FavouriteMealNotifier() : super([]);

  // Method to toggle meal status. And return whether meal was added or not
  bool toggleMealFavouriteStatus(Meal meal) {
    // remove meal if it exist
    if (state.contains(meal)) {
      state = state.where((m) => m.id != meal.id).toList();
      return false;
    }

    // Add Meal if not exist
    else {
      state = [...state, meal];
      return true;
    }
  }
}

// This is provider
final favouritesProvider =
    StateNotifierProvider<FavouriteMealNotifier, List<Meal>>(
  (ref) => FavouriteMealNotifier(),
);
