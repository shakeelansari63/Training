package main

import (
	"fmt"
	"math"
	"math/rand"
	"time"
)

func main() {
	num := 12.497
	sqr := math.Sqrt(num)

	fmt.Println(sqr)

	// We can use Formatted output
	// %g rounds it up where as %f gives correct value
	fmt.Printf("Square root of %g is %.2f \n", num, sqr)

	// Round, Floor adn Ceil fucntions are also available in math package
	fmt.Printf("Round is %f \n", math.Round(sqr))
	fmt.Printf("Floor is %f \n", math.Floor(sqr))
	fmt.Printf("Ceil is %f \n", math.Ceil(sqr))

	// Exponential and Log
	fmt.Printf("E is %f \n", math.E)
	fmt.Printf("ln(E) is %f \n", math.Log(math.E))

	// We can also generate random number using mat library
	// But first we need to add a random seed so that it does not generate same number very time
	rand.Seed(time.Now().UnixNano())
	// And generate random number between 0 - 5
	fmt.Println(rand.Intn(6))
}
