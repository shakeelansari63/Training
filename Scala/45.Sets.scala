// Sets are collection without duplicate
// Sets have some methods for mathematical operations
// Sets need not necessarily maintian order. And they are fast accessed
// e.g.
object Sets extends App {
    // Create some Sets
    val a: Set[Int] = Set(1, 2, 3, 4) // Same as Set.apply(1, 2, 3, 4) as it is on Companion object
    val b = Set(3, 4, 5, 6)
    val c = Set(1, 2, 3, 3, 4, 2) // This has duplicate, but Set will remove duplicates

    println(a) // Set(1, 2, 3, 4)
    println(b) // Set(3, 4, 5, 6)
    println(c) // Set(1, 2, 3, 4)

    // Set Method
    println(a union b) // Combines - Set(1,2,3,4,5,6) not necessarily in same order
    println(a intersect b) // Common in a and b - Set(3, 4)
    println(a diff b) // Values in a not in b - Set(1,2)
    println(b diff a) // values in b not in a - Set(5,6)

    // Union and Intersect are commutative, But diff is not as in Set theory

    // There are infix operators to do same
    println(a ++ b) // is like a union b. But B can be any collection
    println(a ++ List(5, 3, 7)) // Set(1,2,3,4,5,7)

    println(a -- b) // same as a diff b
    println(a -- List(3)) // b need not be set, it can be any collection

    println(a + 5) // new set by adding an element - Set(1,2,3,4,5)
    println(a - 3) // new set by removing an element - Set(1,2,4)

    println(a & b) // same as intersect - Set(3,4)

    // Set access
    // Since sets are not ordered, there is no head, tail, init and last and no access by index
    // So when calling apply method of set object, it tells whether element exist in set or now
    println(a.apply(3)) // Does 3 exist in a - True
    println(a(3)) // Does 3 exist in a - True
    println(a(5)) // Does 5 exist in a - False
    // This is same as contains
    println(a.contains(5)) // False

    // Set als has mkString
    println(a union b mkString ",") // Unions a and b and mkString with delimiter ","

}
