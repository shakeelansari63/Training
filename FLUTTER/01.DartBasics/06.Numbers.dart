void main() {
  int a = 10;
  double b = 22.7;

  print("Integer : ${a}");
  print("Double  : ${b}");

  // Parse number from String
  var x = num.parse('12.765');
  print("Type of X: ${x.runtimeType}");

  // Hach of numerical value
  print("Hasch code of X: ${x.hashCode}");

  // Check if number is finite use isFinite or isInfinite
  print("Is it finite: ${x.isFinite}");

  // Check if Negative, use isNegative
  print("Is it negative: ${x.isNegative}");

  // Convert to String
  print("String of X: " + x.toString());

  // Floor, Ceil and Round of number
  print("Round of X: ${x.round()}");
  print("Floor of X: ${x.floor()}");
  print("Ceil of X: ${x.ceil()}");
}
