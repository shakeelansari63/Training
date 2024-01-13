// Options Types in Scala is like an Optional Value.
// If a variable is Options type, it can either have some value or None
// Options is Abstract Class and cannot be instanciated, it has 2 implementations Some and None
// E.g.

object Options extends App {
    // x is of Option Type

    var x: Option[String] = Some("Hello")
    println(x)

    // This x is now object of Some, So in order to get value, we have to use .get method
    println(x.get)

    // Lets assign None
    x = None
    println(x)

    // Once we assign None value, we cannot use .get on Option, as there won't be any value
    // But how will you know if it is Some or None
    // There are 2 way to work around this
    // 1) use .getOrElse
    val y = Some("Hello")
    val z = None
    println(y.getOrElse("No Value"))
    println(z.getOrElse("No Value"))

    // 2) Use pattern matching
    // Lets create re-usable method for pattern matching
    def getValueFromOption(x: Option[String]): String = x match {
        case Some(value) => value
        case None        => "No Value"
    }

    println(getValueFromOption(y))
    println(getValueFromOption(z))

    // Some sample where Option can be useful
    class Employee private (
        val firstName: String,
        val middleName: Option[String],
        val lastName: String
    ) {
        // If we use default constructor, we have to pass MiddleName as Some(value) or None
        // Thats why we have made primary ctor as private so others cant use it
        // And it can only be initialized with these auxilliary ctors
        def this(firstName: String, middleName: String, lastName: String) =
            this(firstName, Some(middleName), lastName)
        def this(firstName: String, lastName: String) =
            this(firstName, None, lastName)

        override def toString(): String =
            s"Employee($firstName ${middleName.getOrElse(",")} $lastName)"
    }

    // So we can create object of Employee
    val jd = new Employee("John", "Henry", "Doe")
    val js = new Employee("Jon", "Snow")

    println(jd)
    println(js)
}
