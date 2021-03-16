// Dart:async defines asynchronous execution
import 'dart:async';
import 'dart:io';

void main() {
  File fl = new File(Directory.current.path + '/01.DartBasics/test.csv');

  // Read file as Asynchronous which return Future
  Future f = fl.readAsString();
  // When future variable is ready, then print value
  f.then((value) => print(value));

  // Print something else which need not be blocked.
  print('End');
}
