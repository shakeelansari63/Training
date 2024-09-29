package main12

import (
	"fmt"
)

func main() {
	fmt.Println("Pointers")

	// Pointers can be created using pointer syntax
	var a int = 42
	var b *int = &a // *int tell that is pointer to int and &a is address/pointer to a

	fmt.Println("value if a: ", a, "address of a i.e. in b", b, "value in address b: ", *b)

	// So if we change value of one variable other also change, since they are pointing to same address
	a = 10
	fmt.Println("value if a: ", a, "address of a i.e. in b", b, "value in address b: ", *b)

	// Here & is address operator which give address
	// Whereas * is dereferencing oeprator which gives value at address
	// We can also change value by derefering b
	*b = 32
	fmt.Println("value if a: ", a, "address of a i.e. in b", b, "value in address b: ", *b)

	// In array all the values are seperated at interval of size of element
	// and that can be demonstrated by pointer
	c := [3]int{1, 2, 3}
	d := &c[0]
	e := &c[1]
	f := &c[2]
	fmt.Printf("c: %v, d: %p, e: %p, f: %p\n", c, d, e, f)

	// In Go any type which is not initialized will have default value
	// Same goes for pointers
	// default value for pointers in nill
	var ms *myStruct
	fmt.Println(ms)

	// Now if we initialize it, it gets the address of struct
	// We can use new keyword to initialize new empty struct
	ms = new(myStruct)
	fmt.Println(ms)

	// We can set values by dereferencing ms
	// The paramthesis are there to tell go to dereference ms and the get foo
	// otherwise go will dereference ms.foo
	(*ms).foo = 42
	fmt.Println(ms)

	// Now in Go, there is restriction on pointer arithmatic
	// So we cannot manipulate pointers
	// Hence dereferencing is made redundant for struct
	// i.e. we can use ms.foo instead of (*ms).foo
	ms.foo = 37
	fmt.Println(ms)

}

type myStruct struct {
	foo int
}
