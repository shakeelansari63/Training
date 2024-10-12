package main

import (
	"fmt"
	"math"
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
}
