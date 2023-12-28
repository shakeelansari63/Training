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

// Methods can also return data of different Types
def intOrString(a: Int, b: Int) = if (a > b) a + b
else (a + b).toString

println(f"${intOrString(2, 3).getClass}")
println(f"${intOrString(3, 2).getClass}")
