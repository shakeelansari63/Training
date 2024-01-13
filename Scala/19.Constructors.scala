// Though Scala class always creates a primary constructor with all parameters.
// We have way to create auxilliary cunstructors.
// But First statement in all auxilliary constructor should call primary constructor
// Auxilliary constructors are created with this(...) keyword
// Example
class ClassWithAuxilliaryConstructor(
    val param1: String,
    val param2: String,
    val param3: Int
) {
    // This is axilliary constructor which takes only 2 params
    def this(param1: String, param2: String) = this(param1, param2, 0)

    // We can also have another constructor with only 1 parameter and some print statement.
    // But call to this() shoudl be first statement
    def this(param1: String) = {
        this(param1, "", 0)
        println("Constructor with 1 parameter called")
    }

    // Since this call is first in constructor, we can chain auxilliary constructor.
    // Where some constructor in chain calls primary constructor
    def this() = {
        this("") // This calls Constructor with 1 parameter
        println("Constructor with no parameters called")
    }
}

// Lets create soem objects
val cwac1 =
    new ClassWithAuxilliaryConstructor(
      "A",
      "B",
      1
    ) // This calls primary constructor
println(s"${cwac1.param1} ${cwac1.param2} ${cwac1.param3}")

val cwac2 =
    new ClassWithAuxilliaryConstructor(
      "C",
      "D"
    ) // This calls Constructor with 2 parameters
println(s"${cwac2.param1} ${cwac2.param2} ${cwac2.param3}")

val cwac3 = new ClassWithAuxilliaryConstructor(
  "E"
) // This calls constructor with 1 parameter

println(s"${cwac3.param1} ${cwac3.param2} ${cwac3.param3}")

val cwac4 = new ClassWithAuxilliaryConstructor()

println(s"${cwac4.param1} ${cwac4.param2} ${cwac4.param3}")

// Constructors can be defined with defaukt values and can be called with named parametrs just like methods.

class ClassWithDefaultValueConstructor(
    val param1: String = "P1",
    val param2: String = "P2",
    val param3: Int = 0
)

// This class can be instanciated with named arguments while not providing all values
val cwdvc1 = new ClassWithDefaultValueConstructor("PX1", "PX2", 1)
println(s"${cwdvc1.param1} ${cwdvc1.param2} ${cwdvc1.param3}")

val cwdvc2 = new ClassWithDefaultValueConstructor("PY1")
println(s"${cwdvc2.param1} ${cwdvc2.param2} ${cwdvc2.param3}")

val cwdvc3 = new ClassWithDefaultValueConstructor(param2 = "PZ2")
println(s"${cwdvc3.param1} ${cwdvc3.param2} ${cwdvc3.param3}")
