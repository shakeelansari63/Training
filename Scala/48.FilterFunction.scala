// Filter is method to filter a collection based of a condition
// Filter take a function, and check that function on each element
// Finally return collection of elements which satisfy the filter
// e.g.
object FilterFunction extends App {
    // Filter on List
    println(List(1, 2, 3, 4, 5, 6).filter(x => x % 2 == 0)) // Filter only even values
    // Above can be cleanly written as
    println(List(1, 2, 3, 4, 5, 6).filter(_ % 2 == 0))

    // FilterNot is method to filter values which does not satisfy condition
    println(List(1, 2, 3, 4, 5, 6).filterNot(_ % 2 == 0)) // Filter Odd values

    // Exists is method for testing is any element satisfy the condition
    println(List(1, 2, 3, 4, 5, 6).exists(_ % 2 == 0)) // Check if it contain even values
    println(List(1, 2, 3, 4, 5, 6).exists(_ > 10)) // Check if it contain any number >10

    // Filter on range
    // Filter on Range work same as on List
    println(
      1 to 10 by 2 filter (_ % 2 == 0)
    ) // Filter even values. return empty vector as this range only has odd values

    // Filter on Set
    println(Set("Red", "Green", "Indigo").filter(_ contains 'e')) // get set item which has e character

    // Filter on Maps
    println(Map(1 -> "One", 2 -> "Two", 3 -> "Three").filter(t => t._2 contains 'e')) // Normaal Filer
    // Map also has filterKey to filter based on key
    println(Map(1 -> "One", 2 -> "Two", 3 -> "Three").filterKeys(_ % 2 == 0)) // even Keys

    // Filter on Option
    // Since Option has only one value. If filter is applied, it will either return that Some or None
    println(Some(5).filter(_ % 2 == 0)) // 5 is not even so return None
    println(Some(4).filter(_ % 2 == 0)) // 4 is even so return Some(4)

    // Filter are not very efficient with large collections.
    // This is because they return complete collection
    // So Scala came with new method, withFilter
    // withFilter is lazy evaluator making it more memory efficient
    // But we invoke withFilter same as filter, there is no difference
    println((1 to 10).filter(_ % 3 == 0)) // this is list
    println((1 to 10).withFilter(_ % 3 == 0)) // this is traversable object
    println((1 to 10).withFilter(_ % 3 == 0).map(i => i))
    // the traversaable object is evaluated by map and identity function

}
