// Method overriding is way to provide different implementation for Parent class method in child class
// In order to override method in subclass, the signature must be same as parent class
// e.g.
class Employee8(val firstName: String, val lastName: String) {
  require(firstName.nonEmpty, "First Name cannot be empty")
  require(lastName.nonEmpty, "Last Name cannot be empty")

  def fullName = s"$firstName $lastName"
}

class Manager8(firstName: String, lastName: String, val department: String)
    extends Employee8(firstName, lastName) {
  // Lets Override the fullName method
  override def fullName = s"$firstName $lastName from $department Department"
}

val jd = new Employee8("John", "Doe")
val ac = new Manager8("Alan", "Croft", "Mathematics")

println(jd.fullName)
println(ac.fullName)

// The overriden method is used even if we change reference of Manager class object to Employee class object
val acEmp: Employee8 = ac
println(acEmp.fullName)

println(jd.isInstanceOf[Employee8])
println(ac.isInstanceOf[Manager8])
println(ac.isInstanceOf[Employee8])
println(acEmp.isInstanceOf[Manager8])
println(acEmp.isInstanceOf[Employee8])

// equals is special method which comes from AnyRef. By default if we compare 2 objects, it compares their reference and equates to false.
// But we can override this default comparision by overriding equals method since any class is subclass of AnyRef by default

// Similarly, hashCode method also comes from AnyRef to calculate HashCode of an object.
// It can be overrided in class

// And toString is String representation of Class and can be overrided

// Example
class Employee9(val firstName: String, val lastName: String) {
  require(firstName.nonEmpty, "First Name cannot be empty")
  require(lastName.nonEmpty, "Last Name cannot be empty")

  def fullName = s"$firstName $lastName"

  // Overriding default equals methods
  override def equals(x: Any): Boolean = if (!x.isInstanceOf[Employee9]) false
  else {
    val otherEmp = x.asInstanceOf[Employee9]
    this.firstName == otherEmp.firstName && this.lastName == otherEmp.lastName
  }

  // Override default HashCode
  override def hashCode(): Int = {
    var result = 19
    result = 31 * result + firstName.hashCode
    result = 31 * result + lastName.hashCode
    result
  }

  // Override default toString
  override def toString(): String =
    s"Employee(FirstName = $firstName, LastName = $lastName)"
}

// Employee 8 has default implementation of equals, hashCode and toString. And Employee9 has overriden ones
// Lets test
val emp1 = new Employee8("John", "Doe")
val emp2 = new Employee8("John", "Doe")

println(emp1 == emp2) // Gives False
println(emp1.hashCode == emp2.hashCode) // Gives False
println(emp1) // Gves some random text

// Lets test with ones we have overrriden
val emp3 = new Employee9("John", "Doe")
val emp4 = new Employee9("John", "Doe")

println(emp3 == emp4) // Gives True
println(emp3.hashCode == emp4.hashCode) // Gives True
println(emp3) // Gives human readabele text
