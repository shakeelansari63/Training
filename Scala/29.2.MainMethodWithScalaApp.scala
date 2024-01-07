// If we dont want to include main method, we can extend and Object from scala.App and it will execute immediately
object Runner2 extends App {
  println("Hello from scala.App object")
}

// If you compile and check with javap, you see follwing

// public final class Runner2 {
//   public static void main(java.lang.String[]);
//   public static void delayedInit(scala.Function0<scala.runtime.BoxedUnit>);
//   public static long executionStart();
// }
