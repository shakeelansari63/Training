// Try -> Catch -> Finally blocks are used in Scala for handling exceptions
// e.g.
try {
    throw new IllegalArgumentException(
      "This is bad data"
    ) // Try block catches an exception
} catch {
    case iae: IllegalArgumentException =>
        println(
          iae.getMessage
        ) // In scala catch block does not have Exeption tyep,
    // but it is handled inside with case statements
} finally {
    println(
      "Continuing the app..."
    ) // Finally will always run whether exception is thrown or not
}

import scala.util.{Try, Success, Failure}

// There is more functional way for using Try Catach Block
def iMayThrowError: Try[String] = Try(throw new IllegalArgumentException("This is bad data"))

def iMayThrowError(x: String): Try[String] = Try("Hello " + x)

// Try to Get Data
// val tryGetData: Try[String] = iMayThrowError // Throws error
val tryGetData: Try[String] = iMayThrowError("Damon") // Gives result

// And we use pattern matching to evaluate the result
tryGetData match {
    case Success(x)  => println(x)
    case Failure(ex) => println(ex.getMessage)
}
