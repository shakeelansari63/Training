void main() {
  var a = 22;
  var b = 7;

  // For loop
  for (int i = 1; i < b; i++) {
    print('*' * (a - i));
  }

  // While Loop
  int i = 7;
  while (i > 0) {
    print(i);
    i--;
  }

  // Do while loop
  // Will run atleast once
  int j = 22;
  do {
    print(j);
  } while (j > 22);
}
