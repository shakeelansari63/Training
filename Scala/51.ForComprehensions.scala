// For Comprehensions are just simple way to write map, flatMap, filters
// And they make code more readable
// e.g.
object ForComprehensions extends App {
    // Lets Start simple
    val a = 1 to 5
    val b = 4 to 9

    // Add 1 to every element of a
    println(a.map(_ + 1))
    // Same in For comprehension is
    println(for (i <- a) yield i + 1)

    println("------------")

    // Find all even number from a
    println(a.filter(_ % 2 == 0))
    // Same in For comprehension
    println(for (i <- a if i % 2 == 0) yield i)

    println("------------")

    // Lets go complex
    // Cross join a and b
    println(a.flatMap(i => b.map(j => (i, j)))) // we use flatmap to avoid List(List()) from inner map
    // Same can be written in for
    println(for (i <- a; j <- b) yield (i, j))

    println("------------")

    // Cross join even element of a with all elements of b
    println(a.filter(_ % 2 == 0).flatMap(i => b.map(j => (i, j))))
    // Same can be written with For comprehension
    println(for (i <- a if (i % 2 == 0); j <- b) yield (i, j))

    println("------------")

    // Cross Join all elements of a with elements of b less than 7
    println(a.flatMap(i => b.filter(_ < 7).map(j => (i, j))))
    // Same with for comprehension
    println(for (i <- a; j <- b if (j < 7)) yield (i, j))

    println("------------")

    // cross join odd elements of a with elemnets of b greater than 6
    println(a.filterNot(_ % 2 == 0).flatMap(i => b.filter(_ >= 7).map(j => (i, j))))
    // same with for comprehension
    println(
      for (
        i <- a if (i % 2 == 1);
        j <- b if (j >= 7)
      ) yield (i, j)
    )
}
