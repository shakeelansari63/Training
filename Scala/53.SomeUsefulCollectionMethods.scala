// Here are some useful Collection methods
object CollectionMethods extends App {
    // Zip
    // interwine 2 collections. The length of output collection is length of smallest
    println((1 to 5) zip (5 to 9)) // both collections are same size
    println((1 to 4) zip (5 to 9)) // both collections are same size
    println((1 to 5) zip (6 to 9)) // both collections are same size

    // ZipWithIndex
    // Adds index to collection
    println(List("A", "AB", "AC", "BB", "BD", "DA").zipWithIndex)

    // Partition
    // Split collection based on predicate which takes function and return boolean
    println((1 to 10).partition(_ % 2 == 1))

    // Take
    // Take number of elements from left
    println((1 to 10).toList.take(5))

    // TakeRight
    // Take number of elements from right
    println((1 to 10).toList.takeRight(5))

    // TakeWhile
    // Take from left till predicate is false
    println((1 to 10).toList.takeWhile(_ <= 3))

    // GroupBy
    // Create a map with key and values as partition
    println(List("A", "AB", "AC", "BB", "BD", "DA").groupBy(_.head))

    // Distinct
    // remove duplicates
    println(List(1, 2, 3, 4, 2, 3, 5, 6, 4, 8).distinct)
    // can also be done by converting to set and then list
    // but order will not be retained
    println(List(1, 2, 3, 4, 2, 3, 5, 6, 4, 8).toSet.toList)
}
