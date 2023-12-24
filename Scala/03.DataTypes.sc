// Scala does good job of infering type or variable from data. 
// But if it doesn't work, you can define it manually too
// Example
val a = 10       // This will be infered as Int
println(a.getClass.getSimpleName)

val b = "Hello"  // This will be infered as String
println(b.getClass.getSimpleName)

// But if you want to explicitly declare a type, that is doe with :
val c: Double = 10
println(c.getClass.getSimpleName)