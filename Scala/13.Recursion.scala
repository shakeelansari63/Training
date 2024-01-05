// Recursion is technique to call a method from inside itself.
// Since recursive method call themselves, it is difficult for scala to identify return type 
// So it is mandatory to give return type
// Example
def factorial(n: Int): Int = {
    if (n == 0 || n == 1) 1
    else n * factorial(n - 1)
}

println(factorial(5))
println(factorial(100)) // This returns 0 as there is numeric overflow. 

// To avoid Numeric Overflow, we can use BigInt
def bigFactorial(n: BigInt): BigInt = {
    if (n == 0 || n == 1) 1
    else n * bigFactorial(n - 1)
}

println(bigFactorial(5))
println(bigFactorial(100)) 
println(bigFactorial(1000)) 
// println(bigFactorial(10000)) // This Fails dur to Stack Overflow. 
// This is because Scala Use stacks or recursion. And there is limit on stack size.
// To overcome this, we can use Tail optimized recursion
// With Tail Recursive optimization, Scala tries to optimize stack 
// But in Tail recursive method, we cannot perform any action after calling method recursively
// We should simply return it, otherwise Tailrec will not be able to optimize
// In above method, we were multiplying the recursive method call with n which can't be done now
// So we need to use some accumulator to multiply the values
import scala.annotation.tailrec

@tailrec
def tailrecBigFactorial(n: BigInt, accum: BigInt): BigInt = {
    if (n == 0 || n == 1) accum // This returns accumulated value at end
    else tailrecBigFactorial(n - 1, accum *  n) // This Multiply accumulator with n and pass recursively
}

println(tailrecBigFactorial(5, 1))
println(tailrecBigFactorial(100, 1)) 
println(tailrecBigFactorial(1000, 1)) 
println(tailrecBigFactorial(10000, 1)) 