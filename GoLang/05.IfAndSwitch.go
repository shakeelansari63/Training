package main

import "fmt"

func main() {
	num := 2

	// If and Else follow if..else if..else ladder
	if num <= 5 {
		fmt.Println("Less than five")
	} else if num <= 10 {
		fmt.Println("Less than 10")
	} else {
		fmt.Println("Greater than 10")
	}

	// Switch Case work similar to C
	// But you don't need to break out
	switch num {
	case 1:
		fmt.Println("One")

	case 2:
		fmt.Println("Two")

	default:
		fmt.Println("None")
	}
}
