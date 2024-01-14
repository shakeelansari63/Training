// Flatmaps are like maps but they work on Multi-Dimensional Collections
// Flatmap are good to reduce the dimension of collection
// Flatmap signature - flatMap(f: A -> TraversableCollection[B]) -> Collection[B]
// e.g. -

object FlatMaps extends App {
    // Lets see we have multi-dimensional List
    val a: List[List[List[Int]]] = List(
      List(
        List(1, 2),
        List(3, 4)
      ),
      List(
        List(5, 6),
        List(7, 8)
      ),
      List(
        List(9, 10),
        List(11, 12)
      )
    )

    // Now `a` is 3D List, If we just use Map, the map will work on list.
    // We can reduce the dimensions using flatMap and identity function
    // identity functions are function which return whatever they take as input
    println(a.flatMap(x => x)) // This will return 2d List
    println(a.flatMap(x => x).flatMap(x => x)) // This will return 1d List
    // This way of flattening list is so common, list already have flatten method to do same
    println(a.flatten.flatten)

    // We can also apply flatmap on 1d List, given the function returns an itterable
    println(1 to 10 flatMap (x => List(-x, 0, x)))
    // For each item in list, we return list or 3 item which will be flattened by flatMap

    // Flattening Set is same. But Sets will ignore duplicate values
    println(Set(1, 2, 4, 10).flatMap(x => Set(x, x * 5)))
    // This will not return 8 items but 7, since 2*5=10, but 10 is already part of list

    // Flattening a Map
    println(
      Map(1 -> "One", 2 -> "Two", 3 -> "Three").flatMap(t => Map(t._1 -> t._2, (t._1 * 100) -> (t._2 + " Hundred")))
    )

    // We know Options are Collections, so we can run FlatMap on it
    println(Some(5).flatMap(x => Some(x + 5))) // Some(10)
    println(None.asInstanceOf[Option[Int]].flatMap(x => Some(x + 5))) // Still None

    // Lets see, we have list of options with some None values
    // When we run Flatmap, the None will be removed and Some will be converted to actual value
    println(List(Some(3), Some(5), None, None, Some(12), None).flatMap(x => x)) // List(3,5,12)
}
