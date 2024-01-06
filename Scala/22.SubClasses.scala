// Scala Classes can be inherrited from other classes using extends keywork
// It is suggested to create Subclasses if there is Is-A relations
// Example
class Employee7(val firstName: String, val lastName: String) {
  require(firstName.nonEmpty, "First Name cannot be empty")
  require(lastName.nonEmpty, "Last Name cannot be empty")

  def fullName = s"$firstName $lastName"
}

// Lets create a Subclass of Employee i.e. Manager
class Manager1(firstName: String, lastName: String, val department: String)
    extends Employee7(firstName, lastName)

// Now this Manager class will inherit properties from Employee7 class.
// And Notice, firstName and lastName are not defined either val/var.
// This is because Accessor for firstName and lastName are defined in Employee7 class. And we need to repeat it for Manager class

// Lets create some objects
val jd = new Employee7("John", "Doe")

//  We can run fullName method from Employee class on object of Employee
println(jd.fullName)

val ac = new Manager1("Alan", "Croft", "Mathematics")
//  We can also run fullName method from Employee class on object of Manager
println(ac.fullName)

// But Only Manager class gets access to Department
println(ac.department)

println(jd.isInstanceOf[Employee7]) // jd is object of Employee
println(ac.isInstanceOf[Manager1]) // ac is object of Manager
println(
  ac.isInstanceOf[Employee7]
) // ac is also objetc of Employee as Employee is Parent of Manager
