// Dart is stringly typed language

void main() {
  // Number Type
  int i = 10;
  print(i);

  // Float or Double
  double f = 3.14;
  print(f);

  // String Type
  String s = 'Hello'; // It doesn't matter whether you use ' or "
  print(s);

  // We can also user var keyword and compiler will detrrmine the type based
  // on the data
  var v = 2;
  print(v);

  // We can also have varibles which can hold any type
  dynamic d = 7;
  print(d);
  d = "Dynamic Data";
  print(d);
}
