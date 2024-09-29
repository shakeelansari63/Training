// Lets try and get some variables
package main02

import (
	"fmt"     // For Print function
	"strconv" // For String conversion
)

// We can declare variables in Global/Package Scope.
// Here we cannot user := syntax, we have to use var keyword
var globalVar int = 7

func main() {
	// We can define a variable with var keyword
	// If we dont assign a value, it takes default value.
	// Go has many types of int
	// int8  : -128 to 127
	// int16 : -32768 to 32767
	// int32 : -2147483648 to 2147483647
	// int64 : -9.223372e+18 to 9.223372e+18
	// int is dependent of system arch it is 32 for 32bit and 64 for 64bit
	// Similarly there are unsigned int for each corresponding int
	// uint8, uint16, uint32, uint64 & and uint
	// We also have byte data type for uint8
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

	// Var keyword can be redundant in some cases.
	// If we want to assign value to a varible and create it if it does not exist
	// We can use := syntax
	num6 := 8 // Same as var num6 = 8
	fmt.Println(num6)

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

	// Real and imaginary part of complex number can also be checked individually
	// using real and imag functions
	fmt.Printf("Real part : %f \nImaginary Part: %f\n", real(com1), imag(com1))

	// String
	// Strings are UTF8 characters either enclosed in double quotes "" or back ticks ``
	// Default is empty string ""
	var str1 string = "Hello World"
	str2 := `This is also string`
	fmt.Println(str1, str2)

	//Rune
	// Runes is single UTF32 characters defined in single quote
	var rn rune = 'a'
	fmt.Printf("Rune : %v, %T\n", rn, rn)

	// Boolean
	// Boolean types are defined by bool keyword
	// Default is False
	bl1 := true
	bl2 := false
	fmt.Println(bl1, bl2)

	// Type of variable can be printed using %T in Formatted Print
	fmt.Printf("Data Types: %T %T %T %T\n", str1, num1, num8, bl1)

	// You can declare 2 variables of same type in 1 line
	var num4, num5 int

	// But you ccannot declare 2 variables of different type.
	// This wont work
	// var num4 int, num5 bool
	// But we can wrap multiple variables in var to declare different types of vars
	var (
		myvar1 int    = 2
		myvar2 string = "myvar"
		myvar3 bool   = true
	)

	// We can also assign numtiple values to multiple variables
	num4, num5 = 6, 9
	fmt.Println(num4 + num5)
	fmt.Printf("%d %s %t \n", myvar1, myvar2, myvar3)

	// We need to explicitly typecast variables if assiging to another varible type
	// Go does not have implicit type casting
	// Not even int and int8 which are treoratically same
	intDat := 42
	var flDat float32

	// This gives error
	// flDat = intDat
	// But this works fine
	flDat = float32(intDat)
	fmt.Printf("%f \n", flDat)

	// Go behaves starngely when converting Integers to String
	// If we typecast int to String, it looks for unicode character with that int value
	// Use that unicode character as string
	// Below code tries to convert int value 42 to String
	// Unicode character for 42 is * so it prints *
	strDat := string(intDat)
	fmt.Printf("%s\n", strDat)

	// In order to convert integer correctly to string, there is strcov package
	strDat = strconv.Itoa(intDat)
	fmt.Printf("%s\n", strDat)
}
