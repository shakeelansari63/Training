// There are many way to denote a missing value in Scala
/*
 * Null
 * Nil
 * None
 * Unit
 * Nothing
 */
// Lets explore what are they
object NoValues extends App {
    // 1. Null / null
    // null or Null are missing values for reference types
    // null is a value, whereas Null is type for null
    // e.g.
    val a: String = null // No reference in String
    println(a)
    val b: Null = null // Null type can have only 1 value i.e. null
    println(b)

    // 2. Nil
    // Nil is an Empty List
    val c: List[Int] = Nil
    println(c)
    // Or usually used for list building
    val d = 1 :: 2 :: 3 :: Nil
    println(d)

    // 3. None
    // None is also missing value but specifically for Option Type
    // Option types are used for avoiding null reference checks and errors
    val e: Option[Int] = None
    println(e)
    val f: Option[Int] = Some(43)
    println(f)

    // 4. Unit
    // Unit is equivalent to Void in many progarmming languages
    val g: () => Unit = () => println("Hello I return Unit") // This function return Unit
    val h = g() // This call g() and return type is stored in h
    println(h)

    // 5. Nothing
    // Nothing is subclass for everything. It is neither null/None/Null
    // Only way to return Nothing is by throwing Exception
    val i: Int = throw new RuntimeException("Can't Work like this")
}
