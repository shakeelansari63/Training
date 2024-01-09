// In Scala, if there is a method named apply in class / object
// We don't have to call it explicitly. Simply calling Object/class object implicitly calls apply

// e.g.
class Foo1(x: Int) {
  def apply(y: Int) = x + y
}

object Foo2 {
  def apply(y: Int) = y + 5
}

case class Foo3(x: Int)

// So if we create obejct of this class and call object with other value, it will call apply
object MagicApply extends App {
  val foo1 = new Foo1(10)
  println(foo1.apply(3)) // Explicitly call apply
  println(foo1(3)) // Implicitly call apply

  println(Foo2(10)) // implicitly call apply method from Object

  // Remember we can create object of case class without NEW keyword
  // Ever wondered how? It is because case class encapsulate apply method which returns object

  val foo31 = Foo3.apply(10)
  val foo32 = Foo3(12)

  println(foo31)
  println(foo32)
}
