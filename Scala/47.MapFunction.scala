// Map Function is way to iterate over element of collection and generate new collection
// e.g.
import java.lang._
object MapFunctions extends App {
    // Map Function On List
    val a = List(1, 2, 3, 4, 5)
    def add1M(x: Int) = x + 1 // This is a method which takes int and return its square
    val add1F = add1M _ // This is a function created from method

    println(a.map(add1F)) // Map function takes a function as input
    println(a.map(add1M _)) // We can convert method to function on the fly
    println(a.map(add1M)) // We know _ at last is optional
    println(a.map((x: Int) => x + 1)) // We can also use inline function
    println(a.map(x => x + 1)) // Since Data Type of Collection element is already known, we can skip type
    println(a.map(_ + 1)) // We can use _

    // Map Function on Set
    val b = Set("A", "AB", "ABC", "ABCD", "AC", "BDC")
    println(b.map(_.size)) // we map String set and return Int Set.
    // Noticed, Though original set had 6 items, we are getting 4 items, because there are 2 items with same size
    // And Set does not allow duplicate
    println(b.map(x => x -> x.size)) // This returns set of tuples

    // Map Function on Range is same as list
    println(1 to 10 by 2 map (_ * 2))

    // Map Function on String work on each character
    println("Hello!!".map(_ + 2)) // This returns vector of character ASCII values
    // But if we need a string back, we can convert num to Char and use mkString
    println("Hello!!".map(c => (c + 2).toChar).mkString)

    // Map Function on Maps
    val c = Map("FG" -> 1, "BG" -> 2, "KILL" -> 3, "SUSPEND" -> 4)
    println(c.map(t => "Key " + t._1)) // Returns list of Keys with prefix Key
    println(c.map(t => "VAL - " + t._2)) // Return list of values
    println(c.map(t => ("Key: " + t._1) -> ("Val:" + t._2))) // Returns a MAP

    // Map Function on Options
    // Since Option has 1 or 0 value, we can map over Option
    val d: Option[Int] = Some(2)
    val e: Option[Int] = None
    println(d.map(_ + 3)) // 2 + 3 = 5
    println(e.map(_ + 3)) // None + 3 = None
    println(Some(4).map(_ + 2)) // This works because type of input parameter is infered
    // But None.map will not work as Scala wont be able to infer Type Option[T]... T?
    // So we need to cast it using asInstanceOf
    println(None.asInstanceOf[Option[Int]].map(_ + 2)) // It still returns None
}
