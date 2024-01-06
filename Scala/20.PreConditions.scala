// Preconditions in class are validations for primary constructor
// If you want to check some condition whili initializing variables, you can create Pre Conditions using require keyword
// e.g.
class Employee6(val firstName: String, val lastName: String) {
  // These are pre conditions
  require(firstName.nonEmpty, "First Name cannot be empty")
  require(lastName.nonEmpty, "Last Name cannot be empty")
}

// Now if we create an object, it will first check pre condition
val jd = new Employee6(firstName = "John", lastName = "")

// this will throw error - java.lang.IllegalArgumentException: requirement failed: Last Name cannot be empty
// So if require fails it throws IllegalArgumentException
