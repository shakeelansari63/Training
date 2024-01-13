// Arrays in Scala are Mutable collections
// They are represented in same ways as Java Aarray under JVM
// e.g.
object Arrays extends App {
    // Create an array
    val a: Array[Int] = Array(1, 2, 3, 4, 5)
    println(a) // Yes Arrays does not have good toString Methods

    // Data access is same as List
    println(a(2))

    // Arrays support all the methods of List
    println(a.max)
    println(a.head)
    println(a.tail) // Again this is Array, so wont be pretty
    println(a.last)
    println(a :+ 6 mkString ", ")
    println(a ++ List(4, 5, 6, 7) mkString ", ")

    // Arrays are usuallly used in Repeated Method Parameters
    // e.g.
    def demoRepeatedParam(x: Int, y: String, z: Any*) = {
        println(x)
        println(y)
        println(z)
    }

    // Any* in method parameter will consume any value and convert it into array
    // Actually it is wrapped array, which has been modified to have good toString
    // Lets see in action
    demoRepeatedParam(3, "Hi", "yeah", "this", "is", "stupid", 3.00) // We can use any type since it is Any

    // But what if we want that Wrapped array to be List, can we use List
    demoRepeatedParam(3, "Hi", List("yeah", "this", "is", "stupid", 3.00))
    // So above doesn't convert it to List, but its Array if 1 List item
    // We can unravel the List using :_*
    demoRepeatedParam(3, "Hi", List("yeah", "this", "is", "stupid", 3.00): _*)
    // And we get a list in repeated parameters instead of WrappedAray
}
