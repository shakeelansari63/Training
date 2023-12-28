// Scala Methods are defined by def
// And Last evaluated statements value is always returned from method.
// Example
def add(a: Int, b: Int): Int = a + b

println(add(6, 7))

// Since If also returns value in scala, we can use If also in method
def compare(a: Int, b: Int) = if (a > b) "Greater"
else if (a < b) "Smaller"
else "Same"

println(compare(7, 5))
