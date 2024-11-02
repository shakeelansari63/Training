package main

import (
	"bufio"
	"fmt"
	"os"
)

// We will use bufio builtin package to read user input from Standard Input

func main() {
	// Read UserInput
	fmt.Println("----- Read User Input -----")
	// To read input from Standard in we need buffer reader
	reader := bufio.NewReader(os.Stdin)

	// This reader will be used to read data from std in. Now lets print a message to tell user for input
	fmt.Println("Enter a number: ")

	// Reader object returns 2 objects.
	// First - String entered by user in StdIn
	// Second - Error if any error occur
	// This is error handling method in Go. Instead of raising error, it returns error as object
	// Which can be checked and action can be taken
	// But if we want to ignore the error, we can use , _ syntax also called comma ok syntax.
	// In this way, the second returned value is ignored
	num, _ := reader.ReadString('\n')
	fmt.Println("Your Number is : ", num)

	// Lets see what is there in error object
	fmt.Println("Enter another number: ")
	x, err := reader.ReadString('\n')
	fmt.Printf("Value: %s, Type: %T\n\n", x, x)
	fmt.Printf("Value: %s, Type: %T", err, err)
}
