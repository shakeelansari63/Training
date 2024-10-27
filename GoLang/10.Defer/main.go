package main

import (
	"fmt"
)

func main() {
	fmt.Println("Defer control flows")

	// Defer keyword allows to defer the execution of certain statement till the end of current function
	// This is helpful in cases where we are opening some resources
	// and have to cloes them after we have used
	// But if we have lot of work to be done between opening and closing, it is possible
	// that we may forget to close the resources
	// Hence we can simply tell program to defer the closing
	// e.g.
	fmt.Println("Resource Opened")
	defer fmt.Println("Resource Closed")
	fmt.Println("Resource in use")

	// Also if we defer a statement, it takes arguments when it was defered
	// And if argument variable change later, it won't take changed variable
	// Below will print Start not End
	a := "Start"
	defer fmt.Println(a)
	a = "End"

	// Also it should be noted, Deref add teh statements in Stack / LIFO
	// So statement defered in end is executed first
	defer fmt.Println("Statement 1")
	defer fmt.Println("Statement 2")
	defer fmt.Println("Statement 3")
}
