// Companion objects can be used in Factory pattern to instanciate and object of class

// We will need LocalDate class from java.time for employee hireDate
import java.time._

// Lets first make the Default constructor private
case class CompanyEmployee private (
    firstName: String,
    lastName: String,
    title: String,
    hireDate: LocalDate
)

// And Companion Object will be factory
object CompanyEmployee {
  // This is replacement of primary constructor
  def create(
      firstName: String,
      lastName: String,
      title: String,
      hireDate: LocalDate
  ) = CompanyEmployee(firstName, lastName, title, hireDate)

  // And this override method provide way to default hireDate to today
  def create(firstName: String, lastName: String, title: String) =
    CompanyEmployee(firstName, lastName, title, LocalDate.now())
}

// Main Runner
object CERunner extends App {
  val ce1 = CompanyEmployee.create(
    "Jane",
    "Depp",
    "Programmer",
    LocalDate.of(2023, 10, 5)
  )
  val ce2 = CompanyEmployee.create("Mohan", "Bhargav", "Manager")

  println(ce1)
  println(ce2)
}
