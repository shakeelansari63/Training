// Lets create an object of Employee1 class
// In order to run this script, You must first compile the 17.1.Classes.scala file
// And run this script in scala using `scala -cp . 17.2.ClassExample.scala`
// -cp parametr tells the class path to current location.
val obj1 = new Employee1("John", "Doe")
// Now object is created
println(obj1)
// But if you try to access firstName or LastName members of this object, it will throw error.
// println(obj1.firstName) // error: value firstName is not a member of Employee1

// Lets create object of Employee2 which has firstName as accessor and lastName as Mutator
val obj2 = new Employee2("John", "Doe")
println(obj2)

// We can access firstName now
println(obj2.firstName)

// Since lastName is mutator, we can update its value
println(obj2.lastName)
obj2.lastName = "Smith"
println(obj2.lastName)
