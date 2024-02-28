import 'package:app06_meals_app/models/meal.dart';
import 'package:app06_meals_app/widgets/meal_trait.dart';
import 'package:flutter/material.dart';
import 'package:transparent_image/transparent_image.dart';

class MealItem extends StatelessWidget {
  const MealItem({super.key, required this.meal, required this.onMealSelect});
  final Meal meal;

  final void Function(Meal meal) onMealSelect;

  @override
  Widget build(BuildContext context) {
    return Card(
      margin: const EdgeInsets.all(12),
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(24)),
      clipBehavior: Clip.hardEdge,
      elevation: 2,
      child: InkWell(
        onTap: () => onMealSelect(meal),
        child: Stack(
          children: [
            Hero(
              // We will wrap Image on meals list screen with hero to provide transition effect
              tag: meal.id,
              child: FadeInImage(
                placeholder: MemoryImage(kTransparentImage),
                image: NetworkImage(meal.imageUrl),
                fit: BoxFit.cover,
                height: 200,
                width: double.infinity,
              ),
            ),
            Positioned(
              left: 0,
              right: 0,
              bottom: 0,
              child: Container(
                color: Colors.black54,
                child: Column(
                  children: [
                    Text(
                      meal.title,
                      textAlign: TextAlign.center,
                      maxLines: 2,
                      softWrap: true,
                      overflow: TextOverflow.ellipsis,
                      style: const TextStyle(color: Colors.white, fontSize: 20),
                    ),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        MealTrait(
                          icon: Icons.schedule,
                          label: '${meal.duration} min/s',
                        ),
                        const SizedBox(
                          width: 15,
                        ),
                        MealTrait(
                          icon: Icons.work,
                          label: meal.complexity.name,
                        ),
                        const SizedBox(
                          width: 15,
                        ),
                        MealTrait(
                          icon: Icons.attach_money,
                          label: meal.affordability.name,
                        ),
                      ],
                    ),
                  ],
                ),
              ),
            )
          ],
        ),
      ),
    );
  }
}
