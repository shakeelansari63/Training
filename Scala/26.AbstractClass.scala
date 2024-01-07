// Abstract Classes are classes with zero or more abstract methods
// They are like blueprint for a class
// And all the abstract methods must be implemented in Subclass
// These Abstracts classes cannot be instanciated, as they dont have concrete method
// Abstract class start with abstract keyword, but abstract method does not need abstract methdo
// We just skip the implementation in Abstract method
// e.g.
abstract class Person {
  def firstName: String
  def lastName: String
  def fullName: String
}

// Lets extend the person Abstract method in our case class
case class Employee12(firstName: String, lastName: String) extends Person {
  def fullName: String = s"$firstName $lastName"
}

val empjd = Employee12("Jane", "Doe")
println(empjd)

// Employee object can be converted to
val perjd: Person = empjd
println(perjd.fullName)
