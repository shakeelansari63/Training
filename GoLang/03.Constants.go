package main03

import (
	"fmt"
)

// iota is a special symbol which acts as counter
// When we assign iota to a variable or constant, it increments its value
// So from below code block, a=0, b=1 & c=2 will happen
// This is constant enumeration
const (
	a = iota
	b = iota
	c = iota
)

// Interesting about iota is it gets passd to constants i following lines
const (
	k = iota
	l
	m
	n
)

// With iota we have to start with zero. But if we want to ignore it, we can use write only symbol _
// which lets us ignore teh value
const (
	_ = iota
	q
	w
	e
)

func main() {
	// Creating a constant
	// Const keyword can be used to create constants
	const con1 int = 10
	fmt.Println(con1)

	// Constant value has to be defined at compile times.
	// We cannot create a constant whose value need to be determined a runtime
	// So below code won't work
	// const myCon float64 = math.Sin(10)
	// fmt.Println(myCon)

	// Lets see what is in our iota constants
	fmt.Printf("%v, %T\n", a, a)
	fmt.Printf("%v, %T\n", b, b)
	fmt.Printf("%v, %T\n", c, c)

	// Infered iotas
	fmt.Printf("%v, %T\n", k, k)
	fmt.Printf("%v, %T\n", l, l)
	fmt.Printf("%v, %T\n", m, m)
	fmt.Printf("%v, %T\n", n, n)

	// Ignored zero on iota
	fmt.Printf("%v, %T\n", q, q)
	fmt.Printf("%v, %T\n", w, w)
	fmt.Printf("%v, %T\n", e, e)
}
