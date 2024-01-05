// Units are like voids, they don't hold any value
// Units can be created using ()
val a = ()
println(a)
println(a.getClass) // This gives Java class void

// Also Unit is subclass of AnyVal which means it is considered Premitive.
// So if we return Unit and int from same method, the evaluated return type of method will
// be AnyVal
// Example
def add(a: Int, b: Int) = if (a > b) println(s"${a} is greater than ${b}")
                            else a + b

println(add(3, 4)) // This prints 7
println(add(4, 3)) // This will print the greter statemnet which then returns Unit. So Unit is printed.

// Also in Methods, The `=` sign tells to return a value. If we skip that, it will return Unit
// Example
def goodAdd(a: Int, b: Int) = {a + b} // This returns sum
def badAdd(a: Int, b: Int) {a + b} // This returns Unit

println(goodAdd(3, 4))
println(badAdd(3, 4))

// The badAdd method is like explicity returning Unit
def badAdd2(a: Int, b: Int): Unit = {a + b} // This has equal, but we only return unit, so value won't be returned.
println(badAdd2(3, 4))