// Try -> Catch -> Finally blocks are used in Scala for handling exceptions
// e.g.
try {
  throw new IllegalArgumentException(
    "This is bad data"
  ) // Try block catches an exception
} catch {
  case iae: IllegalArgumentException =>
    println(iae.getMessage) // In scala catch block does not have Exeption tyep,
  // but it is handled inside with case statements
} finally {
  println(
    "Continuing the app..."
  ) // Finally will always run whether exception is thrown or not
}
