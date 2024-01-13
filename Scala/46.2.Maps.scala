// Maps are Key value datastructures of Scala
// e.g.
object Maps extends App {
    // Creating a MAP
    val a: Map[Int, String] = Map((1, "One"), (2, "Two")) // By Passing Tuple2 in Map.apply method
    println(a)

    // But we know there is an easier way to making Tuple2 using ->
    val b = Map(1 -> "One", 2 -> "Two", 3 -> "Three", 4 -> "Four")
    println(b)

    // Yes both are maps. But Maps Keys must be unique, we cannot have 2 same keys in Maps
    val c = Map(1 -> "One", 1 -> "Uno", 2 -> "Two", 2 -> "Dos")
    println(c) // Here 2nd value will overwrite first and you will get Map(1 -> Uno, 2 -> Dos)

    // Maps Elements can be accessed by using Map object's apply method
    println(c(1)) // same as c.apply(1)

    // But accessing value this way in map is insecure, if key we are sending does not exist, it will raise exception
    // So there is a safe way to access value
    // i.e. get method which returns Option i.e. Some(Value) or None
    println(a.get(1)) // Some(Uno)
    println(a.get(5)) // None

    // Map Methods
    println(a.toList) // return List of Map - List((1, One),(2, Two))
    println(a.keys) // Gives iterabel of keys -- This is set
    println(a.values) // Gives iterable of values -- This is MapLike
    println(a.values.toSet) // Convert values iterable of MapLike to Set

    // Since Symbols are interned, they are great fit for Map Keys
    val d: Map[Symbol, Int] = Map('A -> 1, 'B -> 2, 'C -> 3)
    println(d)
    println(d.get('A))
}
