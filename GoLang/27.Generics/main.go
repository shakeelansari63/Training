package main

import (
	"fmt"
)

// Generics are usefull for reusing functions and avoiding code duplication due to type limitation
// For Example, if we want to create methods to add 2 numbers
// We can create as follow for ints
func AddInts(a int, b int) int {
	return a + b
}

// And this for floats
func AddFloats(a float32, b float32) float32 {
	return a + b
}

// But we have lot of Number types like
// int8, int16, int32, float32, float64 etc
// And creating individual function for same logic is overkill
// And here we can use Generics
func Add[T int8 | int16 | int32 | int | float32 | float64](a T, b T) T {
	return a + b
}

// Now we are being forced in golang to provide the allowed types in generics
// But This can make our function definition little bulky
// But we can use interface to fix it to some extent
type Nums interface {
	int8 | int16 | int32 | int | float32 | float64
}

func AddNums[T Nums](a T, b T) T {
	return a + b
}

// Now Generics are not limited to functions, we can use generics on structs as well
// Lets say we have a struct and one parameter of that struct can be any number
// We can do this by using generics. Lets use the Nums interface we defined above
type User[T Nums] struct {
	name string
	age  T
}

// And we can have it on Maps as well
// Here in map, we have set its type to comparable
// This comparable is an interface which incorporate the types which can be compared
// e.g. a(int) == b(int) are comparables
type CustomMap[T comparable, V string | float32] map[T]V

func main() {
	fmt.Println("Generics in Golang")

	// To add ints without generics
	fmt.Println(AddInts(3, 5))

	// To add floats without generics
	fmt.Println(AddFloats(3.2, 4.1))

	// To add number with generics
	fmt.Println(Add(3, 4))
	fmt.Println(Add(3.2, 4.2))

	// To add number with generics and simplified interface
	fmt.Println(AddNums(3, 4))
	fmt.Println(AddNums(3.2, 4.2))

	// We can create instance of struct by defining specific data type of age
	u1 := User[int]{
		name: "Jack",
		age:  20,
	}

	u2 := User[float32]{
		name: "John",
		age:  32.1,
	}

	fmt.Printf("%+v\n", u1)
	fmt.Printf("%+v\n", u2)

	// And we can create a map of Custom types as follow
	m := make(CustomMap[int, string])
	m[3] = "Hello"
	fmt.Printf("%+v\n", m)
}
