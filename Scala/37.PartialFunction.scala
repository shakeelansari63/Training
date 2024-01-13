// Partially applied Function is a way to Convert a method into Function
// Example
object PartialFunction extends App {
    // Lets say we have a class with following 2 methods
    class Foo(x: Int) {
        def bar(y: Int) = x + y
        def baz1(y: Int, z: String) = s"$z - ${x + y}"
        def baz2(y: String, z: Int) = s"$y - ${x + z}"
        def qux(f: Int => Int) = f(x)
    }

    // Now we can convert bar method to function as follow
    val x = new Foo(10) // First we need object of Foo

    // bar is simple method, we can covert it into function as follow
    val f1 = x.bar _
    // That last _ is way to indicatte it as partial method, and this makes f1 as function
    println(f1(5))

    // Now lets say we have method with 2 params, and we want it to be converted to a Function1
    val f2 = x.baz1(4, _)
    // Now f2 can be called with 1 parameter
    println(f2("Hello"))

    // We can leave int as partial
    val f3 = x.baz1(_, "Jimmy")
    println(f3(1))

    // We can do samething with baz2
    val f4 = x.baz2(_, 7)
    println(f4("Josh"))

    // If we want an object of Function2, that is also possible
    // The last underscore just convert method to function
    val f5 = x.baz2 _
    // above can also be written as val f5 = x.baz2(_, _)  and it will work same
    println(f5("King", 3))

    // Now what is quz method in Fooo class.
    // quz method takes a function as input and apply the function on x
    // the signature of input function for qux is Int => Int (1 Int input and 1 Int Output)
    // As you can see, our f1 function matches that signature
    // which means we can call
    println(x.qux(f1))

    // But we know f1 = x.bar _, so we can also call
    println(x.qux(x.bar _))

    // But in Scala, if function value end in _, it can be omitted
    println(x.qux(x.bar))
    // So here it looks like we are passing method to qux, but internally it is being converted to function
}
