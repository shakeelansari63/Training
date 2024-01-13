// Rnages are ways to create collection without specifying them one by one
// e.g.
object Ranges extends App {
    // Create Range
    val a: Range = Range(1, 10) // Gives range where upper limit is not included - Range(1 until 10)
    println(a.toList)

    // But if we want to include upper limit we can also do that with inclusive method
    val b = Range.inclusive(1, 10)
    println(b.toList)

    // We can also provide step size
    val c = Range.inclusive(2, 10, 2) // Step by 2
    println(c.toList)

    // And there are easier ways to create Ranges
    val d = 1 to 10 // This  is inclusive way
    println(d.toList)

    val e = 1 until 10 // upper limit excluded
    println(e.toList)

    val f = 1 until 10 by 2 // Step by 2
    println(f.toList)

    val g = 10 to 2 by -2 // Step by -2 i.e. reducing
    println(g.toList)

    // Ranges are goof for For loops
    for (x <- 1 to 10 by 2) print(x + " "); println()
}
