package main11

import (
	"fmt"
	"log"
)

func main() {
	fmt.Println("Panic and Recover control flow ")
	// In Go we have panic instead of exception
	// example is divide by zero -- uncomment below 3 lines
	// a, b := 10, 0
	// ans := a / b
	// fmt.Println(ans)

	// We can also create panic in our application by using panic keyword
	// e.g. -- uncomment below line
	// panic("Someting wrong happened")

	// If we have defers in our application
	// and panic is raised, defered statements are executed then panic is generatd
	// -- uncomment below 4 lines
	// fmt.Println("Start Application")
	// defer fmt.Println("Stop Application")
	// fmt.Println("Application Running")
	// panic("Something went wrong")

	// We have have get teh information of panic using recover keyword
	// and that will also tell app that we are going to deal with panic
	// e.g. -- uncomment below 9 lines
	// fmt.Println("Start Application")
	// // Defer execution of Panic handler which had error handler
	// defer func() {
	// 	if err := recover(); err != nil {
	// 		log.Println("Error: ", err)
	// 	}
	// }() // This is anonymous function
	// panic("Something went wrong")
	// fmt.Println("End Application")

	// Now from above Example, the application paniced and we tried to handle it with defered funcion
	// But it still did not run End Application
	// This is because Panic brings app to end of main and then caused it to execute defered function
	// Since main has already ended, we cannot run anything in main again
	// But if panic happen in some other function, and handled in that function, main will continue to work
	// e.g
	fmt.Println("Start Application main")
	someApplicationCanPanic()
	fmt.Println("End Application main")

	// So last statement in sub application did not run but main continued correctly
}

func someApplicationCanPanic() {
	fmt.Println("Start Application someApplicationCanPanic")
	defer func() {
		if err := recover(); err != nil {
			log.Println("Error: ", err)
		}
	}()

	panic("Something wernt wrong")
	fmt.Println("End Application someApplicationCanPanic")
}
