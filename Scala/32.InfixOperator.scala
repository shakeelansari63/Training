// In Scala Class methods can be used as Infix Operator
// e.g.
class Foo4(x: Int) {
  // Lets say this has 6 methods
  def bar(y: Int) = x + y
  def baz(y: Int, z: Int) = x + y - z
  def qux(y: Int) = new Foo4(x + y)
  def *(y: Int) = x * y
  def apply(y: Int) = x - y
  def +:(y: Int) = x + y
}

object InfixOperator extends App {
  // Lets create object
  val foo = new Foo4(10)

  // Call bar method
  println(foo.bar(5)) // As normal method
  println(foo bar 5) // As Infix Operator

  // Call baz method
  println(foo.baz(5, 2)) // As normal method
  println(
    foo baz (5, 3)
  ) // As Infix Operator. Note parameters are in paramthesis as baz takes 2 params

  // Call qux method. As qux returns new objet of Foo, it can be chained with other qux
  println(foo qux 5 qux 3 qux 9 qux 7 bar 12)

  // As we know, we can create method with symobls
  // So we have create another method * in Foo, and it can be invoked in both ways
  println(foo.*(55))
  println(foo * 55)

  // Apply method can alos be called as infix, but it is easy to call obejct directly
  println(foo.apply(4))
  println(foo apply 4)
  println(foo(4))

  // Now Last one is Right Associative Colon.
  // If a method name ends in Colon, it can be used as Infix in Right Associative way.
  // E.g. -- See the +: method in above class
  println(foo.+:(55)) // Normal Invocation
  println(55 +: foo) // Infix way.
  // But it has to be right associative due to colon (:) at end of method name
}
