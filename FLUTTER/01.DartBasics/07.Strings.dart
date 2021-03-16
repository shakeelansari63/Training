void main() {
  String s1 = "Hello";
  String s2 = "World";

  //length of String
  print("Length of S1: ${s1.length}");

  // Check if string is empty
  print("Is S1 empty: ${s1.isEmpty}");

  // Change Case
  print("Lowercase of S1: ${s1.toLowerCase()}");
  print("Uppercase of S1: ${s1.toUpperCase()}");

  // Concatenation
  print("Concatenation of S1 and S2: " + s1 + " " + s2);

  // Substring, start and end parameter
  print("Substring 1-2 of S1: ${s1.substring(2, 5)}");

  // Split string to List
  print("Split by l on S2: ${s2.split("l")}");

  // Individual character's UTF-16 value can be traversed useing
  print("COde units are: ${s1.codeUnits}");

  // Strings in Dart are sequence of UTF-16 characters.
  // Individual UTF-32 character in Dart are runes
  s1.runes.forEach((element) {
    print(element);
  });
}
