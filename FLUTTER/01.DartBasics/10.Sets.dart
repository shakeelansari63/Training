// Sets are unique collections of objects
import 'dart:collection';

void main() {
  var s1 = new Set();
  s1.add(10);
  s1.add(12);
  s1.add(14);
  s1.add(18);

  // Sets can also be created from List
  var s2 = new Set.from([10, 15, 18, 20, 22]);

  // We can perform set operations on 2 sets
  print("Union: ${s1.union(s2)}");
  print("Intersections: ${s1.intersection(s2)}");
  print("Minus: ${s1.difference(s2)}");

  // HashSets are Hash table based implementation of Set
  // and they do not maintain sequene
  var h1 = new HashSet();
  h1.add(10);
  h1.add(20);
  h1.add(20);
  h1.add(40);

  print("Hash Set: ${h1}");
}
