// IsInstanceOf tells whether an object is instance of a class
// Example
println(3.isInstanceOf[Int])
println(3.isInstanceOf[Double])
println("3".isInstanceOf[String])
println("3".isInstanceOf[CharSequence])

// AsInstanceOf is used to cast an object of one type to other type in same chain
println(3.asInstanceOf[Double])

// They can be used together
// example
def decide(a: Any) = if (a.isInstanceOf[Int]) a.asInstanceOf[Int] + 1 
                    else -1

println(decide(4))       // Return 5
println(decide("Hello")) // Return -1
