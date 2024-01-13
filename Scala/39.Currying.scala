// Currying is process of chaining functions together so that they can be called in parts
// Curried function returns a function unless called with all parameters
// Example
object Currying extends App {
    // This a simple curried method
    val f = (x: Int) => (y: Int) => x + y

    // And it can be called as
    println(f(3)(4))

    // But what if this function was created as normal function which takes 2 params
    val g = (x: Int, y: Int) => x + y
    // This is normal function with 2 parameters
    println(g(3, 4))

    // In order to convert it to curried function, call curried method of function
    val f2 = g.curried

    // Now f2 is curreied and can be called as
    println(f2(4)(5))

    // And curried function can be uncurried with help of Function Object
    val g2 = Function uncurried f2

    // Now to confirm g2 is uncurried function
    println(g2(3, 5))

    // Not only functions, methods can also be curried in Scala
    // e.g.
    def m1(x: Int, y: Int, z: Int) = x + y + z // Normal method
    def m2(x: Int)(y: Int)(z: Int) = x + y + z // Fully curried method
    def m3(x: Int)(y: Int, z: Int) = x + y + z // slip curreid

    println(m1(3, 4, 5))
    println(m2(3)(4)(5))
    println(m3(3)(4, 5))

    // And we know, we can convert method to function using _
    val fx1 = m1 _ // Simple function
    val fx2 = m2 _ // curried function
    val fx3 = m3 _ // split curried function
    val fx4 = m2(2) _ // first parameter set
    val fx5 = m3(2) _ // first parameter set

    // and they can be called as
    println(fx1(2, 3, 4))
    println(fx2(2)(3)(4))
    println(fx3(2)(3, 4))
    println(fx4(3)(4))
    println(fx5(3, 4))
}
