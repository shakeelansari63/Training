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
}
