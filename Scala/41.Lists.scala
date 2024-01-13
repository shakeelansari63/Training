// Lists are immutable list of object in scala
// E.g.
object Lists extends App {
    // Creating a list
    val a: List[Int] = List(1, 2, 3, 4, 5) // This is companion object's apply method i.e. List.apply(***)
    println(a)

    // And this is Empty List
    val b: List[Int] = Nil // This Nil is an Empty list
    println(b)

    // We can also create a list using Nil
    val c = 1 :: 2 :: 3 :: 4 :: Nil
    println(c)
    // Now what is this? Notice :: is infix operator which end in : meaning it is Right Associative
    // So above equation is equivalent to
    val d = Nil.::(4).::(3).::(2).::(1)
    println(d)

    // And Lists have no restriction for duplicates
    val e = List(1, 1, 1, 2, 2)
    println(e)

    // Lists are zero indexed and individual method can b retrieved as
    println(c(2)) // this is equivalent to b.apply(2)

    // List methods
    println(a.head) // Gives 1st element - 1
    println(a.tail) // Gives everything but 1st element - List(2, 3, 4)
    println(a.init) // Gives everything but last element - List(1, 2, 3)
    println(a.last) // Gives last element - 4

    // There are more methods
    println(d.max) // max value from list - 4
    println(d.min) // min value from list - 1
    println(d.isEmpty) // check for empty - false
    println(b.isEmpty) // check for empty - true (since b is Nil)
    println(c.nonEmpty) // check fo non-empty - true

    // List has a neat mkString method to join and create string
    println(a.mkString) // join into string -12345
    println(a.mkString(",")) // join with delimiter ',' - 1,2,3,4,5
    println(a.mkString("[ ", "**", " ]")) // join with delimiter **, with left and right '[ ' & ' ]' - [ 1**2**3**4**5 ]

    // We can update a value, but it returns new list with updated value
    // as lists are immutable
    println(a.updated(2, 9))

    // There are some infix operators
    println(a ++ c) // concat a and c and return new list - List(1,2,3,4,5,1,2,3,4)
    println(a :+ 3) // Add element at end of new list
    println(3 +: a) // Add Element in begining of new list
    println(a ::: c) // It is like a ++ c - List(1,2,3,4,5,1,2,3,4)
}
