package main

import (
	"fmt"
	"reflect"
)

// Interfaces are created similar to how Structs are created
// But difference is, Struct describe data whereas Interfaces describe behaviour
// i.e. Interfaces are composed of method definitions
type Writer interface {
	// We have defined a method in interface, but we haven't implemented this method
	// This will be implemented later
	Write([]byte) (int, error)
}

// Now lets have a Console Wirter Struct which is unrelated to the Writer interface
// But we are going to link them with Writer method later
type ConsoleWriter struct{}

// Here is implementation of writer method which works on object of Structs ConsoleWriter
func (cw ConsoleWriter) Write(data []byte) (int, error) {
	// This method writes to console
	n, err := fmt.Println(string(data))

	return n, err
}

// Like Struct, Interfaces also support Composition
type Shape interface {
	Area() float64
}

type Measurable interface {
	Perimeter() float64
}

// We can have interface which is composition of above 2 interfaces
type Geometry interface {
	Shape
	Measurable
}

// Now lets say we have a function which accets an object of Geometry and shows both Area and perimeter
func describeGeometry(g Geometry) {
	fmt.Println("Area:", g.Area(), "Perimeter:", g.Perimeter())
}

// So now if we create a struct which implements both Shape and Measurable interfaces, it will be same as
// implementing Geometry interface
type Rectangle struct {
	width, height float64
}

// Implementing Shape interface
func (r Rectangle) Area() float64 {
	return r.width * r.height
}

// Implementing Measurable interface
func (r Rectangle) Perimeter() float64 {
	return (2 * r.width) + (2 * r.height)
}

// Now do you know errors in Go
// and how we manage error using ,ok synatx
// Here error is also an interface with following definition
// ```
// type error interface {
// 		Error() string
// }
// ```
// So, if we want to create our own error, we can create a struct which implemnets Error method
// And it will conform to the error's interface and we will be able to use that custom error struct

// Custom Struct
type CalculationError struct {
	msg string
}

// Implement Error method for error interface
func (c CalculationError) Error() string {
	return c.msg
}

// And we can use this custom calculation as follow
func divideNumbers(num float64, den float64) (float64, error) {
	if den == 0 {
		return 0, CalculationError{msg: "Cannot divide by 0"}
	}

	return num / den, nil
}

func main() {
	fmt.Println("Interfaces")

	// Now we have interface defined
	// We have a Struct defined and Write method implemented in context of ConsoleWriter Struct
	// So we can create an instance of Struct and call writer
	var w Writer = ConsoleWriter{}
	w.Write([]byte("Hello Console !!!"))

	// Lets check the Rectngle struct and see if it really confirms to Geometry interface
	r := Rectangle{width: 12.3, height: 13.4}
	// As we don't get any error, we can say Rectangle conforms to Geometry interface
	describeGeometry(r)

	// Also we can use the calculation error as follow
	a, err := divideNumbers(3, 0)
	fmt.Println("Result:", a, "Error: ", err)

	b, err := divideNumbers(3, 2)
	fmt.Println("Result:", b, "Error: ", err)

	// We can also have empty interfaces
	// Since empty interfaces does not have any methods, they can be be assigned any data type
	// as they don't need to implement any method
	var i1 interface{} = 3
	fmt.Println(reflect.TypeOf(i1))

	// But now that this is an interface type, and though we know it has int value, we cannot type cast it
	// Following will error out
	// i2 := int(i1)
	// Its because int casting for interface is not defined
	// In this case, we can use Type assertion
	if i2, ok := i1.(int); ok {
		fmt.Println("Extracted form Interface - ", i2)
	}
	// Above logic will not typecast, but will try to extract an int value from interface
	// And will set OK to boolean based on whether it succeed in doing so or now

}
