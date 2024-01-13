// Case classes bring some neat defaults for Scala Classes
// 1. Case Class automatically implement equals, hashCode and toString methods as we were overriding in previous lecture
// 2. Case class removes use of new keywork to instanciate a class object
// 3. Case class removes need for val keywords in parameters and it is considered default
// 4. Case class have automatics Pattern Matching. (We don't know what is pattern matching yet, but it is similar to switch case)
// 5. Case class adds copy method which allows to create a copy of object with some different parameter

// There is 1 caveat in Case class. They cannot be subclassed by another case class.
// This is because of Copy method. We cannot overload a method in scala if it has default values.
// And since copy method has default values, it cannot be overloaded. But If we subclass case class in case class
// , the copy method in subcalss will try to overload the copy method from parent class.

// Example of Case class
// This is our regular class
class Employee10(val firstName: String, val lastName: String) {
    require(firstName.nonEmpty, "First Name cannot be empty")
    require(lastName.nonEmpty, "Last Name cannot be empty")

    def fullName = s"$firstName $lastName"
}

// This is our case class
case class Employee11(firstName: String, lastName: String) {
    require(firstName.nonEmpty, "First Name cannot be empty")
    require(lastName.nonEmpty, "Last Name cannot be empty")

    def fullName = s"$firstName $lastName"
}

// Lets try to create objects of these classes and compare
val emp1 = new Employee10("John", "Doe")
val emp2 = new Employee10("John", "Doe")

println(emp1 == emp2) // Gives False
println(emp1.hashCode == emp2.hashCode) // Gives False
println(emp1) // Gves some random text

// Lets test case class objects
val emp3 = Employee11("John", "Doe")
val emp4 = Employee11("John", "Doe")

println(emp3 == emp4) // Gives True
println(emp3.hashCode == emp4.hashCode) // Gives True
println(emp3) // Gives human readabele text

// Also create copy of an employee
val emp5 = emp3.copy(lastName = "Dae")
println(emp5)
