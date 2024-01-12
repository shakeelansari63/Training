// Closures are something closed around an environment
// For example a function which takes values from objetc it is in
class Foo8(x: Int) {
  def bar(f: Int => Int) = f(x)
}

object Closures extends App {
  val m = 150
  val f = (x: Int) => x + m
  // In above funtion, m is not defined in function.
  // But it is defined in environemt/context of f
  // That is this object

  // So even if we pass the function f to something else,
  // it will remember value of m
  val foo = new Foo8(100)
  println(foo.bar(f))
}
