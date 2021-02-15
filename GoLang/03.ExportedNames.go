package main

import "fmt"

func main() {
	// Notice the Println is starting with capital letter
	// This is not just mistake, it is intentional.
	// fmt is a package and functions starting with capital letters are only accessible
	// outside by another package
	// If Function name start with small letter, it wont be accessible outside
	// even if somebody import your package
	fmt.Println("Hello There")
}
