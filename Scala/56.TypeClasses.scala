// TypeClass is a design pattern which says, we can define trait implementation for some types and not others
// to provide ad-hoc polymorphism
// e.g.
object TypeClassPattern extends App {
    // Type Class Patterm uses implicits heavily
    // Lets say we have a trait
    trait Summable[T] {
        def sumElements(list: List[T]): T
    }

    // Now, lets create 2 implementations of this trait. But make them implicit
    implicit object IntSummable extends Summable[Int] {
        override def sumElements(list: List[Int]): Int = list.sum
    }

    implicit object StringSummable extends Summable[String] {
        override def sumElements(list: List[String]): String = list.mkString
    }

    // And now we create a method which would take a list and Sum the elements
    // But there is 1 difference, it takes another curried parameter which is implicit
    def processList[T](list: List[T])(implicit summable: Summable[T]): T = {
        summable.sumElements(list)
    }

    // Now what is happening here????
    // Basically, we have 2 Implicit Objects in scope which are implementations of Summable Trait
    // Int & String.
    // And Our process list takes 2nd implicit parameter as Summable Object
    // This forces our Process List to be able to process only List[Int] and List[String]
    // If there is any other List type like List[Boolean], Code will not be able to find and Implicit method for Summable[Boolean]
    // And It will throw error at compile time
    // This is TypeClass Pattern

    // Demo -
    println(processList(List(1, 2, 3, 4))) // List[Int]
    println(processList(List("One ", "two ", "Three ", "Four"))) // List[String]

    // But List[Double] will fail
    // println(processList(List(1.2, 2.4, 6.8))) // List[Double] - Throws Error
}
