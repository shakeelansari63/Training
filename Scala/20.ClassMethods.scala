// Class methods are methods on class which can be called from class object
// Example
class Employee4(val firstName: String = "John", val lastName: String = "Doe") {
    def fullName = s"$firstName $lastName"
}

// lets create object
val js = new Employee4(firstName = "Jane", lastName = "Smith")
println(js.fullName)

// Since both the member variables of Employee4 are immutable, they can't be changed
// In Scala, the pattern to change any variable is to return a copy of object with new value
class Employee5(val firstName: String = "John", val lastName: String = "Doe") {
    def fullName = s"$firstName $lastName"

    // Copy methods to create copy while replacing some values
    def copy(
        firstName: String = this.firstName,
        lastName: String = this.lastName
    ) = new Employee5(firstName, lastName)
}

val dr = new Employee5(firstName = "Denis", lastName = "Ritchie")
val dtm = dr.copy(lastName = "The Mennace")

println(dr.fullName)
println(dtm.fullName)
