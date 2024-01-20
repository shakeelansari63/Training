// Parametrrized Types are ways to work with generics in Scala
// Usually if our method can return different types based on input, we can define all as Any
def anyDecide(b: Boolean, x: Any, y: Any) = if (b) x else y

println(anyDecide(true, 3, 'c'))
println(anyDecide(false, "Hello", 9))

// But problem is they are always of type Any.
// So if there is any method, which takes Int type, wil not be able to handle return from above method
def printInt(n: Int) = println(n)

// printInt(anyDecide(true, 3, 4)) // Though 3 is returned, it is Any can can't be casted to Int

// In Scala Generic Type can be fined as follow
def genericDecide[T](b: Boolean, x: T, y: T): T = if (b) x else y
println(genericDecide(true, 3, 5))

// And to Test, we can call Print Int and confirm that return type is Int
printInt(genericDecide(true, 3, 4))
