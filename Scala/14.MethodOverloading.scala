// Method names can be overloaded in Scala as long as they have different signature.
// By Signature, it means Number of parameters and their types
// Example
def add3(x: Int) = x + 3
def add3(x: Double) = x + 3.0
def add3(x: String) = x + " Three"

println(add3(3))
println(add3(5.0))
println(add3("One Two"))

// Return type is not considered in signature,
// so two methods with dame input but different return type cannot be overloaded
// And following will cause error
// def doSomething(n: Int): Int = n + 5
// def doSomething(x: Int): Double = x + 5.0

// doSomething(3)
