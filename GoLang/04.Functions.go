package main

import "fmt"

// My Function to add
// Return types are defined after function parameter
func add(x int, y int) int {
	return x + y
}

// We can have function which can return multiple values
// Also if arguments have same, we can avoid specifying teh type mutiple times
// And we need to speficy all the return types
func multipleOps(x, y int) (int, int, int) {
	return x + y, x - y, x * y
}

// We can also declare the return types in function definition
// that way we dont have to specify them in return

func ohMyFunction(x, y int) (sum, diff int) {
	sum = x + y
	diff = x - y

	return
}

func main() {
	num1, num2 := 2, 4

	result := add(num1, num2)

	sum, dif, prod := multipleOps(num1, num2)

	fmt.Println(result)
	fmt.Println(sum, dif, prod)

	fmt.Println(ohMyFunction(num1, num2))
}
