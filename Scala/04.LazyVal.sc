// Lazy vals are not evaluated on forst call. They are evaluated when they are called. 
// A subsequest call will only return value and will not re-evaluate
// Example
lazy val a = {println("Evaluated"); 5}   // Print will not be called here

println("Still no evalaution...")
// Now if we call a, it will evaaluate
println(a)

// And lazy evaluation can be usefull if we use some value before its initialized.
// Example
// val b = c + 10      // Here c is not initialized yet
// val c = 5
// println(b)

// But if we convert them to Lazy, same will work
lazy val b = c + 10      // Here c is not initialized yet
lazy val c = 5
println(b)

// Only vals are lazy. If you try to have lazy vars, it will throw error
// lazy var d = 9