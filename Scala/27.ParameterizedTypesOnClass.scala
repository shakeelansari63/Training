// Parameterized Types on Class are similar to that on method
// They are denoted by Single Letter usually `T` and Scala will track the type used to initialize the class
// e.g.
case class Box[T](inp: T)

// Now we can create an instance of box class with any type and get same type in return
val b1 = Box(1) // implicitly Box[Int]
val b2: Box[String] = Box("Hello") // explicitly Box[String]

println(b1.inp)
println(b1.inp.getClass)

println(b2.inp)
println(b2.inp.getClass)

// The type can be anything even same class
val b3 = Box(Box(3)) // Box[Box[Int]]
println(b3.inp.inp)

// We can have class with more than one types
case class Couple[T, U](first: T, second: U)
val c1 = Couple(3, "Hello") // Implicit Couple[Int, String]
val c2: Couple[Int, Double] = Couple(2, 3.0)
println(c1)
println(c2)

// We can mix
val c3 = Couple(Box("Hello"), Couple("Work", 3.0))
println(c3)

// Now to access hello, we call
println(c3.first.inp)
// And to Access Work
println(c3.second.first)

// We can also have Parameterized Method
// Class methods gets access to Types
case class Couple2[T, U](first: T, second: U) {
  def swap: Couple2[U, T] = Couple2(second, first)
}

// Class methods can also take another type as input
case class Box2[T](inp: T) {
  def coupleWith[U](other: U) = Box2(Couple2(inp, other))
}

val b4 = Box2(3) // This creates Box2[Int]
println(b4)
val b5 = b4.coupleWith("Byeee") // This return Box2[Couple2[Int, String]]
println(b5)
val c4 = b5.inp.swap // This will return Couple[String, Int]
println(c4)
