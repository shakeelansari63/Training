/* Scala Methods are defined by def
 * And Last evaluated statements value is always returned from method.
 * Example */
def add(a: Int, b: Int): Int = a + b;

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

// Methods can also be defined inside other method.
// This is usefull if we need a method for some work inside other method only.
// We we don't want it to be used by outside world

def someMethod(n: Int): Int = {
    def otherMethod(n: Int): Int = {
        n * 2
    }

    otherMethod(n)
}

println(someMethod(3))

// Like variables, Method names can also contain special character if it is put in backtick or special symbol is precededd by underscore
def `Special method 1`(n: Int) = n + 2
println(`Special method 1`(4))

// Or with underscore
def areYouHappy_?() = true
println(if (areYouHappy_?) "Nice" else "Ugh!!")

// Or we can also have reserve works in backtick
def `return`(n: Int) = n + 5
println(`return`(4))
