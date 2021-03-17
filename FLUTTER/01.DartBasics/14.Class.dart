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

class Animal {
  int legs = 0;
  Animal.mammal() {
    this.legs = 4;
  }

  Animal.bird() {
    this.legs = 2;
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

  var a1 = Animal.bird();
  print(a1.legs);
  var a2 = Animal.mammal();
  print(a2.legs);
}
