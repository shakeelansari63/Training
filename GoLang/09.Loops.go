// Lets try and get some loops
package main09

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
	k := 0
	for {
		fmt.Println("Loop Ran when K = ", k)
		// Close loop after some condition happen
		k += 11
		if k > 50 {
			break
		}
	}

	// For initializing multiple variables and incrementig them, we can use go's ability to initialize
	// and update multiple variables at once
	for i, j := 1, 1; i <= 6 && j <= 10; i, j = i+1, j*i {
		fmt.Printf("i = %d & j = %d\n", i, j)
	}

	// If we want to iterate over Arrays / Slices / Maps we can iterate using special range keyword
	// e.g
	lst := []int{1, 3, 5, 7, 9}
	mp := map[string]int{
		"k1": 1,
		"k2": 1,
		"k3": 2,
		"k4": 3,
	}
	for key, val := range lst {
		fmt.Println("Key: ", key, "value: ", val)
	}

	for key, val := range mp {
		fmt.Println("Key: ", key, "value: ", val)
	}
}
