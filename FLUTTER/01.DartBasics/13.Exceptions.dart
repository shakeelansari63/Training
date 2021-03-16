// Dart handles exceptions with try / on / catch / finally statements
void main() {
  int a = 10;
  int b = 0;

  // Try for division
  try {
    int c = a ~/ b;
    print("Dividend is : ${c}");
  } on IntegerDivisionByZeroException {
    // Handle division by zero exception
    print("Cannot Divite by Zero");
  } finally {
    // Finally block will always run whether exception occurs or not.
    print("This will run always");
  }
}
