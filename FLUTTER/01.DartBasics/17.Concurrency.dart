// Isolate package from dart can be used to spawn threads
import 'dart:isolate';

void main() {
  Isolate.spawn(func, 1);
  Isolate.spawn(func, 2);
  Isolate.spawn(func, 3);
  Isolate.spawn(func, 4);
  Isolate.spawn(func, 5);
  Isolate.spawn(func, 6);
  Isolate.spawn(func, 7);
  Isolate.spawn(func, 8);
  Isolate.spawn(func, 9);
}

void func(int a) {
  print("Hello ${a}");
}
