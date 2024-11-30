package main

import (
	"fmt"
	"io"
	"os"
)

func main() {
	fmt.Println("Lets work with some file")
	// In go there is no 1 library to work with files. There are many libraries
	// to facilitate working with text files easier
	fileName := "./my-testing-file.txt"

	// To create a new File, we can use os module
	// os.Create takes name of file and create a file pointer which can be used for writing file
	file, err := os.Create(fileName)
	handleError(err)
	// We will defer the file closing event. This is better done in begining as we may forget to close it later.
	// And Defer keyword will make sure the file is closed just before program ends.
	defer file.Close()

	// Now that we have file opened, and closing is also taken care, lets do some something with file
	// This method will write some content in File
	writeContent(file, "Hello world!!!, This is first content to file")

	// This method will read the file content
	readContent(fileName)

}

func writeContent(fl *os.File, content string) {
	// We will use io module to write string content to a file
	// io.WriteString returns the length of content written to file
	length, err := io.WriteString(fl, content)
	handleError(err)

	fmt.Println("Length of content written to file - ", length)
}

func readContent(fl string) {
	content, err := os.ReadFile(fl)
	handleError(err)

	// When reading file, the content is actually in bytes not string
	// So if we print content as it is, we see some random numbers
	fmt.Println(content)

	// But if we need the content in human readable string, we can convert it to string
	fmt.Println(string(content))
}

// Common Error Hadling as it will be needed a lot in file management
func handleError(err error) {
	if err != nil {
		// Raise panic if error occured
		panic(err)
	}
}
