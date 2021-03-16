void main() {
  // Declare a new list
  var l1 = [];

  // Add Items to list
  l1.add(3);
  l1.add(7.4);
  l1.add("hello world");

  // See list values
  print("List is: ${l1}");

  // Length of list
  print("Length of List is: ${l1.length}");

  // Reversed list
  print("Eeversed List is: ${l1.reversed}");

  // Check if list is empty
  print("Is List empty: ${l1.isEmpty}");

  // First Element of list
  print("First Element of List is: ${l1.first}");

  // Last element of list
  print("Last Element of List is: ${l1.last}");

  // Extend list by another list
  var l2 = [12, 15.8];
  l1.addAll(l2);

  // Insert element at particular position
  l1.insert(0, "first item");
  print("List is now: ${l1}");

  // Remove Item of index
  dynamic res = l1.removeAt(2);
  print("List is now: ${l1} and removed item is: ${res}");

  // remove range form list
  l1.removeRange(2, 4);
  print("List is now: ${l1}");
}
