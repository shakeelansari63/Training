// Implicits are ways to implicitly convert one type to other
object Implicits extends App {
    // Lets say we have 1 class with some methods
    case class Person(name: String) {
        def greet = println(s"Hello my name is $name, Lets Rock")
    }

    // We can define a method/function to implicitly convert a string to Person Object
    implicit val stringToPerson: (String) => Person = (name: String) => Person(name)

    // Now this implicit method allows us to do some crazy stuff
    "Alice".greet
    // Scala will automatically find an implicit method to convert a string to person and call greet method from it

    // Also Implicits can be used as function/method parameter
    // e.g.
    def getMap(implicit key: String): Map[String, Int] = Map(key -> 0)
    // Now we can call this method with explicit values
    println(getMap("One"))

    // But now, we can also create an implicit String value in scope and call the method with no params
    implicit val defaultKey: String = "Default"
    println(getMap)

    // Implicits are usually used with Curried Methods and implicit objects/functions/methods
    implicit val multiplyBy2 = (item: List[Int]) => item.sum * 2
    implicit val concatAndAppend2 = (item: List[String]) => item.mkString + "2"

    def doSomething[T](item: List[T])(implicit doable: (List[T]) => T) = doable(item)

    println(doSomething(List(1, 2, 3, 4)))
    println(doSomething(List("1", "2", "3", "4")))

    // Implicits are core part of TypeClass Patter which we will see next
}
