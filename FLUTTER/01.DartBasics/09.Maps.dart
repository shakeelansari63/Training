// maps are key valuee pairs in dart
import 'dart:collection';

void main() {
  var m1 = new Map();

  // Add item
  m1['k1'] = 'v1';
  m1['k2'] = 'v2';

  print("Map is: ${m1}");

  // Loop over map and apply some function on each element
  m1.forEach((k, v) {
    print(k);
    print(v);
  });

  // hash maps are hash table implementation of Maps which does not guarantee any order
  var h1 = new HashMap();
  h1['name'] = 'Shakeel';
  h1['age'] = 30;

  print("Hash Map: ${h1}");
}
