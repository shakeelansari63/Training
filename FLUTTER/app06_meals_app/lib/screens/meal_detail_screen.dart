import 'package:app06_meals_app/models/meal.dart';
import 'package:app06_meals_app/providers/favourites_provider.dart';
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:transparent_image/transparent_image.dart';

class MealDetailScreen extends ConsumerWidget {
  const MealDetailScreen({super.key, required this.meal});

  final Meal meal;

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final favMeals = ref.watch(favouritesProvider);
    final isFav = favMeals.contains(meal);

    return Scaffold(
      appBar: AppBar(
        title: Text(meal.title),
        actions: [
          IconButton(
            onPressed: () {
              final mealmarkedFav = ref
                  .read(favouritesProvider.notifier)
                  .toggleMealFavouriteStatus(meal);

              if (mealmarkedFav) {
                ScaffoldMessenger.of(context).clearSnackBars();
                ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(
                    content: Text('Meal added to favourite'),
                  ),
                );
              } else {
                ScaffoldMessenger.of(context).clearSnackBars();
                ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(
                    content: Text('Meal removed from favourite'),
                  ),
                );
              }
            },
            icon: AnimatedSwitcher(
              duration: Durations.medium1, // ~250ms
              transitionBuilder: (child, animation) => FadeTransition(
                opacity: animation, // Give Animation Controller
                child: child,
              ),
              // We also need to add key to icon to tell Flutter that icon changed
              child: Icon(
                isFav ? Icons.favorite : Icons.favorite_border,
                key: ValueKey(isFav),
              ),
            ),
          ),
        ],
      ),
      body: SingleChildScrollView(
        child: Column(
          children: [
            Hero(
              // Also wrap meal detail in hero with same tag for animation to work
              tag: meal.id,
              child: FadeInImage(
                placeholder: MemoryImage(kTransparentImage),
                image: NetworkImage(meal.imageUrl),
                height: 300,
                width: double.infinity,
                fit: BoxFit.cover,
              ),
            ),
            Container(
              padding: const EdgeInsets.symmetric(vertical: 0, horizontal: 15),
              child: Column(
                children: [
                  const SizedBox(
                    height: 12,
                  ),
                  Text(
                    'Ingredients',
                    style: Theme.of(context)
                        .textTheme
                        .titleLarge!
                        .copyWith(color: Theme.of(context).colorScheme.primary),
                  ),
                  const SizedBox(
                    height: 12,
                  ),
                  Text(
                    meal.ingredients.join(', '),
                    textAlign: TextAlign.center,
                    style: Theme.of(context).textTheme.bodyMedium!.copyWith(
                        color: Theme.of(context).colorScheme.onBackground),
                  ),
                  const SizedBox(
                    height: 12,
                  ),
                  Text(
                    'Steps',
                    style: Theme.of(context)
                        .textTheme
                        .titleLarge!
                        .copyWith(color: Theme.of(context).colorScheme.primary),
                  ),
                  const SizedBox(
                    height: 12,
                  ),
                  Text(
                    meal.steps.join('\n'),
                    style: Theme.of(context).textTheme.bodyMedium!.copyWith(
                        color: Theme.of(context).colorScheme.onBackground),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
