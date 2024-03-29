// Pattern matching is like switch case in other languages.
// We try to match the value arre do something
// Example
val aa = 3
aa match {
    case 1 => println("One")
    case 2 => println("Two")
    case 3 => println("Three")
    case 4 => println("Four")
    case _ => println("Default")
}

// It can also be used in Function with return value
def find(x: Int) = x match {
    case 1 => "One"
    case 2 => "Two"
    case 3 => "Three"
    case 4 => "Four"
    case _ => "Default"
}

println(find(12))

// Pattern Matching can also have some guards
val amt = 50
amt match {
    case x if x <= 50 => println(s"$x Amount is less than or equal to 50")
    case x if x > 50  => println(s"$x Amount is greater than 50")
}
