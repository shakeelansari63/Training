// Enums are lists which can be substituted for integer values
enum Status { RUNNING, STOPPED, PAUSED, UNKNOWN }
void main() {
  // Seach each value
  print("Running status is: ${Status.RUNNING}");

  print("All Statuses are: ${Status.values}");

  Status.values.forEach((element) {
    print("Value is ${element} with integer ${element.index}");
  });
}
