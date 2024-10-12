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

func main() {
	fmt.Println("Interfaces")

	// Now we have interface defined
	// We have a Struct defined and Write method implemented in context of ConsoleWriter Struct
	// So we can create an instance of Struct and call writer
	var w Writer = ConsoleWriter{}
	w.Write([]byte("Hello Console !!!"))

	// We can also have empty interfaces
	// Since empty interfaces does not have any methods, they can be be assigned any data type
	// as they don't need to implement any method
	var Int interface{} = 3
	fmt.Println(reflect.TypeOf(Int))
}
