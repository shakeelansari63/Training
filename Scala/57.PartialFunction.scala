// Partial Functions are functions which are defined  only on subset of defined domain.
// They should not be confused with Partially Applied Functions, which is way to create function with lesser values
// Partial Functions use Pattern matching to define Subset
// e.g.
object PartialFunctions extends App {
    // Lets say we have a Function which takes int and returns int
    val square: Int => Int = (x: Int) => x * x
    // So the square method os defined for all values of Int, we can give any Int value and it will work
    println(square(32))
    println(square(5))

    // But lets say we have restriction, we want our function to only accept some int values
    // We can do it with If
    val fuzzySquare: Int => Int = (x: Int) =>
        if (x < 10) x * x * x
        else if (x < 20) x * x
        else throw new RuntimeException
    // so this function can take only values which are less than 20. If we give it value >= 20, it will throw Exception
    println(fuzzySquare(5))
    println(fuzzySquare(12))
    // println(fuzzySquare(35)) // This will raise RuntimeException

    // As number of conditions grow, the If Else will also grow, and beome un-managable. So we can use Pattern matching to simplify
    val fuzzySquare2: Int => Int = (x: Int) =>
        x match {
            case x if x < 10 => x * x * x
            case x if x < 20 => x * x
        }
    // So it is same with our pattern matching, and since we don't have default value, it will throw Match Error for non matching values
    println(fuzzySquare2(2))
    println(fuzzySquare2(17))
    // println(fuzzySquare2(31)) // Throws MatchError

    // this is exactlt what partial function is, but we have a simpler syntax
    val squarePartialFunc: PartialFunction[Int, Int] = {
        case x if x < 10 => x * x * x
        case x if x < 20 => x * x
    }
    // Notice we havent given Input type and => to define function and `x match` for pattern matching
    println(fuzzySquare2(7))
    println(fuzzySquare2(13))
    // println(fuzzySquare2(42)) // Still throws MatchError

    // Under the Hood, Partial Functions are Object of PartialFunctions Trait
    // So we can also implement Partial Function as
    val pf1 = new PartialFunction[Int, String] {
        override def apply(x: Int): String = x match {
            case 1 => "One"
            case 2 => "Two"
            case 3 => "Three"
        }
        override def isDefinedAt(x: Int): Boolean =
            x == 1 || x == 2 || x == 3
    }
    // And we can invoke it as normal partial function
    println(pf1(1)) // One
    println(pf1(3)) // Three
    // println(pf1(4)) // MatchError

    // Working with Partial Functions
    // Now we know partial functions are defined at subset of domain, and if we give it value outside subset, it will throw error
    // So Scala provide an method to check if partial function is defined at certain value
    println(squarePartialFunc.isDefinedAt(2)) // true
    println(squarePartialFunc.isDefinedAt(12)) // true
    println(squarePartialFunc.isDefinedAt(22)) // false

    // And Partial Function can be lifted to total function to return options
    val optionalSquare: Int => Option[Int] = squarePartialFunc.lift
    println(optionalSquare(5)) // Some[Int]
    println(optionalSquare(15)) // Some[Int]
    println(optionalSquare(25)) // None

    // An we can add more sudsets using orElse
    val squareWithMoreSubset: PartialFunction[Int, Int] = squarePartialFunc.orElse {
        case x if x < 30 => x
    }
    println(squareWithMoreSubset(5)) // match case from squarePartialFunc
    println(squareWithMoreSubset(15)) // match case from squarePartialFunc
    println(squareWithMoreSubset(25)) // match additioaanl case from squareWithMoreSubset
    // println(squareWithMoreSubset(35)) // throw MatchError

    // Since Complete / Total functions are Superset of Partial Functions,
    // We can create a total function but still assigning it partial function
    val someSquareFunction: Int => Int = {
        case 1 => 32
        case 2 => 42
        case 3 => 56
    }
    // And we can call it as normal function.
    println(someSquareFunction(2))
    // println(someSquareFunction(5)) // Throws MatchError
    // But since it is not Partial Function, we cannot use isDefineAt / list / orElse methods on this total function

    // Since we can replace Total Function with Partial, it alo=lows us to use the partial Function where total function is needed
    val someList = List(1, 2, 3) map {
        case 1 => 32
        case 2 => 42
        case 3 => 56
    }
    println(someList) // Will return List(32, 42, 56)
    // But if we had List(1, 2, 5) but 5 is not defined in partial function, it would throw error

    // Or use with Collect to filter some values
    val anotherList = List(1, 2, 3, 4, "Hello", "Junkie") collect {
        case x if x.isInstanceOf[Int] => x
    }
    println(anotherList) // This gives list of integers and ignores teh string values
}
