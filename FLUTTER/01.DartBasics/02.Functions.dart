// Functions are very similar to functions in C

// This function does not retunr anything
void printSum(double n1, double n2) {
  print(n1 + n2);
}

double returnSum(double n1, double n2) {
  return n1 + n2;
}

// If a function has only 1 expression, it can be written in short hand notation
void printDiff(double n1, double n2) => print(n1 - n2);

// We can return the value as
// The retunr value of expression is returned by function
double returnDiff(double n1, double n2) => n1 - n2;

void main() {
  printSum(1.5, 3.2);

  print(returnSum(7.4, 2.1));

  printDiff(10.7, 3.8);

  print(returnDiff(7.5, 4.2));
}
