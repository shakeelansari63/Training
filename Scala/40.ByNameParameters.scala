// By Name parameters are parameters which are evaluated lazily.
// And provide ease or writing code
// Example
object ByNameParameter extends App {
    // Lets have some methods
    def byValue(x: Int)(y: Int) = { println("ByValue - Method Called"); x + y }

    def byFunction(x: Int)(y: () => Int) = {
        println("ByFunction - Method Called"); x + y()
    }

    def byName(x: Int)(y: => Int) = { println("ByName - Method Called"); x + y }

    // Lets call these methods
    // But while calling 2nd parameter, we have some side-effect.
    // Which will tell us when is 2nd Parameter evaluated.

    println(byValue(3) { println("ByValue 'Y' parameter evaluated"); 20 })
    // ByValue 'Y' parameter evaluated
    // ByValue - Method Called
    // 23

    println(byFunction(3)(() => { println("ByFunction 'Y' parameter evaluated"); 20 }))
    // ByFunction - Method Called
    // ByFunction 'Y' parameter evaluated
    // 23

    println(byName(3) { println("ByName 'Y' parameter evaluated"); 20 })
    // ByName - Method Called
    // ByName 'Y' parameter evaluated
    // 23

    // Now what is to notice is ,
    // In ByValue, Y parameter is evaluated before method call. Which means parameter evaluation is eager
    // But in ByFunction, Y parameter is evaluated after method call, when Y is actually needed. So parameter evaluation is eager
    // But the syntax in little clumsy, as we have a function call
    // This brings ByName, which acts exactly like ByFunction, but syntax is simple like ByValue
}
