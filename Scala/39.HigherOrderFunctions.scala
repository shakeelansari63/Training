// Higher order functions are function which can take a function as input or return a function as output
// Example
object HigherOrderFunction extends App {
    val f1 = (x: Int, f: Int => Int) => f(x)
    // 2nd parameter of f1 is function and final output is Int
    // So we can call it as
    val f2 = (x: Int) => x * 3

    println(f1(3, f2))

    // But we dont need to declare f2, we can use anonymous function
    println(f1(7, (x: Int) => x * 3))

    // Lets cleanup a little, we already know f1 takes function which haas input as Int, so lets type inference do its work
    println(f1(5, x => x * 3))

    // We can also do little more cleanup using _ which will be replaced by input and output
    println(f1(8, _ * 3))

    // _ can be switched, as it just replace value of input
    println(f1(9, 3 * _))

    // And we know, if _ is at last, it can be ommited
    // It will work, but it will give warning to use -feature flag for compiling
    // We can compile with scalac -feature to see warning.

    // And it will show -
    // warning: postfix operator * should be enabled
    // by making the implicit value scala.language.postfixOps visible.
    // This can be achieved by adding the import clause 'import scala.language.postfixOps'
    // or by setting the compiler option -language:postfixOps.
    // See the Scaladoc for value scala.language.postfixOps for a discussion
    // why the feature should be explicitly enabled.
    //   println(f1(2, 3 *))
    //                   ^
    // one warning found

    // So to avoid warning -
    import scala.language.postfixOps
    println(f1(2, 3 *))

    // We can also return a function from function
    // e.g.
    val g = (x: Int) => (y: Int) => x + y
    // g is a fucntion which takes int input and return a function which also takes int input and return int output
    // Now the returned function has closure of x as it will remember x

    val g1 = g(3) // g1 is also function
    println(g1(4))

    // But we don't need g1, we can do -
    println(g(3)(9))
    // This way of chaining functions is also called currying
}
