// Lets try to print value 100 to 1 in descending order seperated by comma
var a = 100
var res = ""
while (a >= 1) {
    res = res + a
    if (a > 1) res = res + ", "
    a = a - 1
}
println(res)

// But same can be achieved without running a while loop
val res2 = (1 to 100).reverse.mkString(", ")
println(res2)

// Or generate list which is already reverse
val res3 = (100 to 1 by -1).mkString(", ")
println(res3)
