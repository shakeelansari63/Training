// Lets try and get some variables
package main

import "fmt"

func main() {
	// We can define a variable with var keyword
	// If we dont assign a value, it takes default value.
	// Default for int is 0
	var num1 int

	// We can also assign value to number while declaring it
	var num2 int = 3

	// If we assign a variable value, it is not compulsary to give its type.
	// Go can identify the type from input value
	var num3 = 2

	// In Go if we have declared a variable but not used it, it gives an error
	// So we should use the variables
	fmt.Println(num1, num2, num3)

	// You can declare 2 variables of same type in 1 line
	var num4, num5 int

	// But you ccannot declare 2 variables of different type.
	// This wont work
	// var num4 int, num5 bool

	// We can also assign numtiple values to multiple variables
	num4, num5 = 6, 9
	fmt.Println(num4 + num5)

	// Var keyword can be redundant in some cases.
	// If we want to assign value to a varible and create it if it does not exist
	// We can use := syntax
	num6 := 8 // Same as var num6 = 8
	fmt.Println(num6)

	// Const keyword can be used to create constants
	const num7 int = 10
	fmt.Println(num7)

	// Float Data Types
	// Float32 for 32bit and Float64 for 64bit Floating Point NUmber
	// Default for Float is 0.0
	var num8 float32 = 10.5
	var num9 float64 = 19.7
	fmt.Println(num8, num9)

	// Complex Numbers are complex64 and complex128 since they have floating point parts
	// Default is 0+0i
	var com1 complex64 = 10 + 5i
	var com2 complex128 = 19 + 7.5i
	fmt.Println(com1, com2)

	// String
	// Strings are either enclosed in double quotes "" or back ticks ``
	// Default is empty string ""
	var str1 string = "Hello World"
	str2 := `This is also string`
	fmt.Println(str1, str2)

	// Boolean
	// Boolean types are defined by bool keyword
	// Default is False
	bl1 := true
	bl2 := false
	fmt.Println(bl1, bl2)
}
