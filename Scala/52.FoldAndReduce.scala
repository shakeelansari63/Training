// Fold and Reduce are ways to reduce the collection
// There is just 1 difference between Fold and Reduce,
// We provide a seed in Fold, but Reduce automatically takes 1st / last value as seed
// e.g.
object FoldAndReduce extends App {
    // Fold Left start with seed, then iterate over collection left to right and perform binary operation
    println(
      (1 to 10).foldLeft(0)((total, next) => { println(s"Total: $total, Next: $next"); total + next })
    ) // here 0 is seed
    // Same in reduce
    println(
      (1 to 10).reduceLeft((total, next) => { println(s"Total: $total, Next: $next"); total + next })
    )
    // Notice Fold runs 10 times but Reduce ran 9 times,
    // because fold's start value was 0 and it iterate collection from 1st element
    // but reduce's start element is 1st element of collection so it start form 2nd element of collection

    // Fold Left can also be used to return value of type which is not type of element in collection
    println((1 to 10).foldLeft("0")((str, element) => str + ", " + element)) // This is like mkString
    println((1 to 10).mkString("0, ", ", ", ""))

    // Similar to FoldLeft and ReduceLeft, there are fold Right and reduce right
    // They iterate over collection from right to left, and parameter sequence in function are reversed
    println(
      (1 to 10).foldRight(0)((next, total) => { println(s"Total: $total, Next: $next"); total + next })
    ) // here 0 is seed
    // Same in reduce
    println(
      (1 to 10).reduceRight((next, total) => { println(s"Total: $total, Next: $next"); total + next })
    )

    // And there are fold and reduce functions. Fold works like FoldLeft and Reduce works like ReduceLeft
    println(
      (1 to 10).fold(0)((a1, a2) => { println(s"Start: $a1, Next: $a2"); a1 + a2 })
    )
    println(
      (1 to 10).reduce((a1, a2) => { println(s"Start: $a1, Next: $a2"); a1 + a2 })
    )
}
