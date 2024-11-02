package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	// Convert data types
	fmt.Println("----- Convert data types -----")
	// Lets say we have a string where some value exist in float
	// While the data type is string, we cannot perform any numeric opration
	// So we have to convert the data type of the variable to float
	// We that using strconv package
	n1s := "32"
	n1, _ := strconv.ParseFloat(n1s, 32) // Parse into 32 bit float

	fmt.Println("Added 1 to your number: ", n1+1)

	// But if there is error in conversion, how would we know? It is captured through 2nd return object i.e. error
	n2, err1 := strconv.ParseFloat("ab", 32)

	// And we check error as follow
	if err1 != nil {
		fmt.Println("Error occured", err1)
	} else {
		fmt.Println("Added 1 to your number: ", n2+1)
	}
	// This will return error message

	// So where to use this conversion?
	// Best example is while reading from standart input
	fmt.Println("Enter your number: ")
	reader := bufio.NewReader(os.Stdin)
	n3s, _ := reader.ReadString('\n')
	n3, err2 := strconv.ParseFloat(n3s, 32)

	// And we check error as follow
	if err2 != nil {
		fmt.Println("Error occured", err2)
	} else {
		fmt.Println("Added 1 to your number: ", n3+1)
	}

	// So what happened here? Why did we get error?
	// This is because stdin returns new line character in outout value
	// This need to be trimmed
	fmt.Println("Lets try again\nEnter your number: ")
	n4s, _ := reader.ReadString('\n')
	n4, err3 := strconv.ParseFloat(strings.TrimSpace(n4s), 32)

	// And we check error as follow
	if err3 != nil {
		fmt.Println("Error occured", err3)
	} else {
		fmt.Println("Added 1 to your number: ", n4+1)
	}
}
