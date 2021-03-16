// Typedef are pointers to functions and they can be changed anytime
typedef GenericCalc(int a, int b);

int Sum(int a, int b) => a + b;
int Dif(int a, int b) => a - b;
int Mul(int a, int b) => a * b;
int Div(int a, int b) => a ~/ b;
void main() {
  // This Generic Calc object can take any function which match its signature
  // of 2 inputs
  GenericCalc calc = Sum;
  print(calc(22, 7));
  calc = Dif;
  print(calc(22, 7));
  calc = Mul;
  print(calc(22, 7));
  calc = Div;
  print(calc(22, 7));
}
