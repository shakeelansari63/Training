object Function extends App {
    // Function as traits which take some thing and return something
    // Functions are objects of Classes FunctionX
    // Where X i 0..22, So our Function can take max 22 parameters
    // And we implement apply method of FunctionX class
    // Example
    val f1: Function0[Int] = new Function0[Int] {
        def apply(): Int = 1
    }

    val f2: Function1[Int, Int] = new Function1[Int, Int] {
        def apply(x: Int): Int = x + 5
    }

    val f3: Function3[Int, Int, String, String] =
        new Function3[Int, Int, String, String] {
            def apply(x: Int, y: Int, z: String): String = s"$z - $x $y"
        }

    // Now we can call functions using apply method
    println(f1.apply())
    println(f2.apply(3))
    println(f3.apply(2, 3, "Hi"))

    // Now we know, apply method is not necessary, so we cal also call them as
    println(f1())
    println(f2(3))
    println(f3(2, 3, "Hi"))

    // Lets do little more cleanup
    // We don't have to instanciate instance of FunctionX class for creating function
    // There is easier way to do it using brackerts and =>
    // Example
    val f4: () => Int = () => 1
    val f5: (Int) => Int = (x: Int) => x + 5
    val f6: (Int, Int, String) => String = (x: Int, y: Int, z: String) => s"$z - $x $y"
    println(f4())
    println(f5(3))
    println(f6(2, 3, "Hi"))

    // Lets make it more cleaner with Type Inferencing
    val f7 = () => 1
    val f8 = (x: Int) => x + 5
    val f9 = (x: Int, y: Int, z: String) => s"$z - $x $y"
    println(f7())
    println(f8(3))
    println(f9(2, 3, "Hi"))

    // Difference between Function and Method.
    // Functions are objects of Class FunctionX
    // Where methods are not instance. They belong to a context (Like class, object or trait)
    // Functions can also be called with .apply method, but methods dont have another .apply method
}
