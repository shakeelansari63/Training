// For loops in Scala are For Each loops
// example
var result = ""
for (a <- (100 to 1 by -1)) {
    result = result + a;

    if (a > 1)
        result = result + ", "
}

println(result)

// We can also loop over list. 
// Here is how to loop over list and generate new list with squares
val a = List(1, 2, 3, 4, 5)
var b = List[Int]()
for (l <- a) b = b :+ (l * l)
println(b)

// Scala also has For Comprehension
val c = List(1, 2, 3, 4, 5)
val d = for(l <- c) yield(l*l)
println(d)