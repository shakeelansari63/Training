// We know in Java, we have a main mothod which is static
// We can have it in Scala using Obejcy
object Runner {
    def main(args: Array[String]) = println("Hello from Scala")
}
// Lets try to run this, you will immediatly get output.
// This is because main is special method, which will be executed immediately
// If we compile and check with javap, we will get following

// public final class Runner {
//   public static void main(java.lang.String[]);
// }
