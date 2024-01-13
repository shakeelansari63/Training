// We can write if as we do in any other Programming language
val a = 10
var res = ""

if (a < 10) res = "Less"
else if (a > 10) res = "Greater"
else res = "Equal"

println(res)

// But here we used var as we had to change th evalue of res. But there is another way to return value from if
val b = 10
val res2 =
    if (b < 10) "Less"
    else if (b > 10) "Greater"
    else "Equal"

println(res2)
