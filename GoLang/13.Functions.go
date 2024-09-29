package main13

import "fmt"

func main() {
	num1, num2 := 2, 4

	result := add(num1, num2)

	sum, dif, prod := multipleOps(num1, num2)

	fmt.Println(result)
	fmt.Println(sum, dif, prod)

	fmt.Println(ohMyFunction(num1, num2))

	// Passing premitive types to arguments are call by value except slices and maps
	// Passing slices and maps are call by reference by default
	// Call by Value doed not change original variables
	x := "Stacey"
	y := "John"
	callByValue(x, y)
	fmt.Println(x, y)

	// Call by reference changes the variable value
	callByReference(&x, &y)
	fmt.Println(x, y)

	// We can also make Go to take arbitrary amount of parameters
	// and define processing function to take it all in a slice
	// e.g
	numSum(1, 2, 3)
	numSum(1, 2, 3, 4, 5)
	numSum(1, 2, 3, 4, 5, 6, 7, 8)

	// Go has ability to return error if there are some cases where error can be generated
	// Function getting non zero values
	val, err := numDiv(10., 2.)
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println(val)
	}

	//function getting zero value will return error
	val, err = numDiv(10., 0.)
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println(val)
	}

	// Go also has concept of anonymous function which can be as type
	// e.g.
	anomFunc := func() {
		fmt.Println("Hello World")
	}
	anomFunc()

	// But this also allow us to send this anonymous function to another function
	getFunc(anomFunc)

	// Methods in Go are just functions which can be executed in known context
	// Meaning, we have to define the context for methods
	// For example consider the Struct Greeting and function greet
	// greet function executes with context of struct greeting
	g := Greeting{
		greeting: "Hello",
		name:     "Susan",
	}
	// Call greet with context of g
	g.greet()
	// Since call by value create copy of struct, we can have different func for call by ref
	g.greetByRef()
}

// My Function to add
// Return types are defined after function parameter
func add(x int, y int) int {
	return x + y
}

// We can have function which can return multiple values
// Also if arguments have same, we can avoid specifying teh type mutiple times
// And we need to speficy all the return types
func multipleOps(x, y int) (int, int, int) {
	return x + y, x - y, x * y
}

// We can also declare the return types in function definition
// that way we dont have to specify them in return

func ohMyFunction(x, y int) (sum, diff int) {
	sum = x + y
	diff = x - y

	return
}

// Function to be called by value
func callByValue(x, y string) {
	fmt.Println("Hello", x, y)
	x = "Ted"
	y = "Lory"
	fmt.Println("Hello", x, y)
}

// Function to be called by refrence
func callByReference(x, y *string) {
	fmt.Println("Hello", *x, *y)
	*x = "Ted"
	*y = "Lory"
	fmt.Println("Hello", *x, *y)
}

// Variable length parameters
func numSum(values ...int) {
	sum := 0
	for _, v := range values {
		sum += v
	}
	fmt.Println(sum)
}

// Function which can return zero
func numDiv(x, y float32) (float32, error) {
	if y == 0.0 {
		return 0.0, fmt.Errorf("Cannot Divide by zero")
	}
	return x / y, nil
}

// Accept Function as parameter
func getFunc(x func()) {
	x()
}

// Struct for Greeting
type Greeting struct {
	greeting string
	name     string
}

// (g Greeting) is context for function greet
// So this method can only be invoked by
// instance of Greeting Struct
func (g Greeting) greet() {
	fmt.Println(g.greeting, g.name)
}

// As we would expect, since we are passing struct as context,
// it create a new copy of object. So in order to avoid creating multiple copies of struct
// We ca use Pointers and Struct already has implicit dereferencing, which can help
func (g *Greeting) greetByRef() {
	fmt.Println(g.greeting, g.name)
}
