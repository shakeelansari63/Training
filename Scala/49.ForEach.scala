// Foreach is very much like Map
// Only Difference is Map returns a collection, but foreach returns Nothing/Unit
// E.g.
object ForEach extends App {
    // Map Example
    println(1 to 10 map println _) // This also return Vector or Units

    // ForEach
    println(1 to 10 foreach println _) // This only return Unit

    // This is because map is defined as --> map(f: A -> B): Collection[B]
    // but foreach is defined as --> forEach(f: A -> Unit): Unit
}
