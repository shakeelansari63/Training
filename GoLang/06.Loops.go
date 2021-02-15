// Lets try and get some loops
package main

import "fmt"

func main() {
	// Go has only 1 loop which is for loop
	// Following for loop will run 5 times
	for i := 1; i <= 5; i++ {
		fmt.Println("Loop 1", i)
	}

	// We can run for loop with just condition keeping initialization and increment outside
	j := 0
	for j < 5 {
		fmt.Println("Loop 2", j)
		j++
	}

	// If we completely remove the condition, for loop will run for ever
	// Following code has been commented to avoid infinite loop
	// for {
	// 	fmt.Println("Infinite Loop")
	// }
}
