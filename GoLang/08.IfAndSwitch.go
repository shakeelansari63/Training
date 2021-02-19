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

	// Another useful syntax with If in go is with initialized and check
	// For example we can have a map and we can get a key using ok syntax and check the ok variable
	// in same if statement
	mp := map[string]int{
		"key1": 10,
		"key2": 20,
		"key3": 30,
	}
	// Check
	if pop, ok := mp["key4"]; ok {
		// Pop and Ok variables are only defined in scope of this block
		fmt.Println("key4: ", pop) // We can also access pop variable here

		// So this gives us opportunity to redefine pop and ok in else block without error
	} else if pop, ok := mp["key2"]; ok {

		fmt.Println("key2: ", pop) // and use here
	} else {
		fmt.Println("no key")
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
