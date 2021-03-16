// Dart is object oriented language
// meaning everything in dart is object

// creating class
class Person {
  String name = '';
  int age = 0;

  // Constructor
  Person(String name, int age) {
    // Use this keyword for accessing class properties
    this.name = name;
    this.age = age;
  }
  // Dart allow arguments to be named arguments
  // meaning they are optional and can be set using parameter name
  // E.g.
  void setParm({String name = '', int age = 0}) {
    if (name != '') {
      this.name = name;
    }

    if (age != 0) {
      this.age = age;
    }
  }
}

void main() {
  var p1 = Person('Mark', 30);
  print(p1.name);
  print(p1.age);
  p1.setParm(name: 'Mary');
  print(p1.name);
  p1.setParm(age: 21);
  print(p1.age);
}
