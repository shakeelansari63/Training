package main

import (
	"fmt"
)

func main() {
	a := 10
	b := 3

	// Mathematical opetrators
	fmt.Println("a + b = ", a+b) // Addition
	fmt.Println("a - b = ", a-b) // Substraction
	fmt.Println("a * b = ", a*b) // Multiplication
	fmt.Println("a / b = ", a/b) // Division
	fmt.Println("a % b = ", a%b) // Modular Division

	// Bitwise Operators
	fmt.Println("a and b = ", a&b)  // Bitwise AND
	fmt.Println("a or b = ", a|b)   // Bitwise OR
	fmt.Println("a xor b = ", a^b)  // Bitwise XOR
	fmt.Println("a nor b = ", a&^b) // Bitwise NOR

	// Bitwise Shift operators
	fmt.Println("3 bit left shift for a = ", a<<3)
	fmt.Println("3 bit right shift for a = ", a>>3)

	// String Operations
	s1 := "I am test String1"
	s2 := "I am test String 2"
	// Concatenation
	fmt.Println(s1 + s2)

	// Accessing individual string charatcer.
	// Note individual string charatcer us Utf8 charatcer which makes it uint8 type
	fmt.Printf("%v, %T\n", s1[2], s1[2])

	// Converting String into collection / array of bytes
	bt := []byte(s2)
	fmt.Printf("%v, %T\n", bt, bt)

}
