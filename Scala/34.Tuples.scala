// Tuples are immutable containers of objects
// They can store multiple values of Different Types
// E.g.
object Tuples extends App {
    val t = (1, "Hello", 43.20) // This is Tupple
    println(t)

    // How to Define Type of Tuple
    // 1) By putting types in parenthesis
    val t2: (String, Int, Boolean) = ("Hello", 32, false)
    println(t2)

    // 2) Using TupleXX class
    val t3: Tuple2[Int, Double] = (2, 22.4)
    println(t3)

    // How to access individual item in tupe
    // Using _x notation.
    // And yes Tuples are starting with 1st Index
    println(t2._1)
    println(t2._3)
    println(t3._2)

    // Max limit of Tuple is Tuple22. So maximum we can store 22 values in a tuple

    // Tuple2 has an additional method called swap, which returns new tuple with values swapped
    val t4: Tuple2[Int, String] = (4, "T4")
    val t5 = t4.swap
    println(t4)
    println(t5)

    // Also there is an Elegant way to create Tuple2
    val t6 = 2 -> "Two" // This created Tuple2 as (2, "Two")
    println(t6)

    // What if we use multiple ->, it will create mulyiple Tuple2's embedded in one another
    val t7 = 7 -> "T7" -> "July" -> 7.00
    // This will first create Tuple 2 of 7 -> "T7" as (7, T7)
    // Then it will create Tuple2 of (7, T7) -> "July" as ((7, T7), July)
    // And Finally it will create Tuple2 of ((7, T7), July) -> 7.00 as (((7, T7), July), 7.0)
    println(t7)

    // So how would we access "T7" in tuple t7
    println(t7._1._1._2)
    // t7._1 = ((7, T7), July)
    // (t7._1)._1 = (7, T7)
    // ((t7._1)._1)._2 = "T7"
}
