// Queue is FIFO Data structure
import 'dart:collection';

void main() {
  var q = new Queue();
  // Add individual item to queue
  q.add(10);
  q.add(14);

  // Add from list to a queue
  q.addAll([15, 18, 31]);

  // Lets see the queue
  print("Queue: ${q}");

  // Remoev item, removes from front
  dynamic r = q.removeFirst();
  print("Queue: ${q} removed element is ${r}");
}
