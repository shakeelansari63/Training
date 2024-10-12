package main

import (
	"fmt"
)

func main() {
	// Arrays & Slices
	fmt.Println("----- Arrays & Slices -----")

	// Arrays are created using []type syntax
	var arr1 [3]string
	arr1[0] = "Hello"
	arr1[1] = "Hi"
	arr1[2] = "Bye"

	fmt.Println(arr1)

	// Below syntax create an array of 3 elements of size int and initialize it to values 10, 11, 15
	arr2 := [3]int{10, 11, 15}
	fmt.Println(arr2)

	// But size is redundant here, since we are already initializing array
	// So we can skip to define size using ... syntax and Go will create array
	// large enough to accomodate the initialized values
	arr3 := [...]float32{10.5, 12.8, 3.14}
	fmt.Println(arr3)

	// Individual elements can be accessed by [] syntax
	fmt.Println("2nd Floating point number is: ", arr3[1])

	// Length of array can be checked by builtin len function
	fmt.Println("Length of arr1: ", len(arr1))

	// Multi Dimensional Array
	// This create a 2 dimensional array
	var arr4 [3][3]int
	arr4[0] = [3]int{1, 0, 0}
	arr4[1] = [3]int{0, 1, 0}
	arr4[2] = [3]int{0, 0, 1}
	fmt.Println(arr4)

	// Same can also be written in one line as but above syntax is much cleaner
	arr5 := [3][3]int{[...]int{1, 0, 0}, [...]int{0, 1, 0}, [3]int{0, 0, 1}}
	fmt.Println(arr5)

	// In Go Arrays are actual values not pointers
	// So if you copy an array into another array, it creates new copy
	// and both can be changed independently
	arr6 := arr3
	arr6[2] = 6.9
	fmt.Printf("arr3: %v \narr6: %v\n", arr3, arr6)

	// This can cause problem if we try to pass huge array to a function.
	// If we pass array to a function by value, it copies whole array causing memory hog
	// And easiest way yo avoid this is using pointers which we will see later
	arr7 := &arr6
	arr7[2] = 11.0
	fmt.Printf("arr6: %v \narr7: %v\n", arr6, arr7)

	// Slices are extension of array where it does not have fixed size
	// Declaring a slice
	slc1 := []int{1, 2, 3} // Note we have not given any size not even ...
	// Slice support most of functions supported by Array like len function
	fmt.Println("Length of slice slc1: ", len(slc1))

	// By default Slices are reference type,
	// meaning copying slice to another slice does not create duplicate
	slc2 := slc1
	slc2[2] = 5
	fmt.Printf("slc1: %v \nslc2: %v\n", slc1, slc2)

	// Slices allow slicing of array
	// Note: Slicing operation also work with arrays.
	// And slicing force it to reference meaning slices are pointing to same array instead of making copy
	slc3 := []int{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
	slc4 := slc3[:]   // new slice with all elements of slc3
	slc5 := slc3[4:]  // new slice with all elements after 4th element including 4th elemnt
	slc6 := slc3[:5]  // new slice with all elements before 5th elemnt excluding 5th element
	slc7 := slc3[2:7] // new slice with all elements between 2nd and 7th element including 2nd excluding 7th
	fmt.Println("Slc3: ", slc3)
	fmt.Println("Slc4: ", slc4)
	fmt.Println("Slc5: ", slc5)
	fmt.Println("Slc6: ", slc6)
	fmt.Println("Slc7: ", slc7)

	// But there is another function which is specific to Slice i.e. capacity
	// When length counts elements in slice, capacity counts max elements which can be accomodated
	// In below case, slc1 is initialised while declaring so capacity and length are same
	// whereas slc 7 is slice of slc3, so capacity is calculated by starting from slice start of slc7
	// till end element of slc3. Hence len and cap differ in this case
	fmt.Println("Length of slice slc1: ", len(slc1), " | Capacity of slice slc1: ", cap(slc1))
	fmt.Println("Length of slice slc7: ", len(slc7), " | Capacity of slice slc7: ", cap(slc7))

	// We can make slices of big capacity using make method
	slc8 := make([]int, 3, 100) // 1st is data type, 2nd is number of elements, 3rd is capacity
	fmt.Println("SLC8: ", slc8,
		" | Length of slice slc8: ", len(slc8),
		" | Capacity of slice slc8: ", cap(slc8))

	// Slices have ability to add or remove elements dynamically without defining fixed size
	slc9 := []int{}
	fmt.Println("SLC9: ", slc9,
		" | Length of slice: ", len(slc9),
		" | Capacity of slice: ", cap(slc9))
	// Append an element
	slc9 = append(slc9, 5) // Append element 5
	fmt.Println("SLC9: ", slc9,
		" | Length of slice: ", len(slc9),
		" | Capacity of slice: ", cap(slc9))
	// All values after 1st Append arguments are treated as value to append
	slc9 = append(slc9, 2, 6, 3, 8, 7)
	fmt.Println("SLC9: ", slc9,
		" | Length of slice: ", len(slc9),
		" | Capacity of slice: ", cap(slc9))

	// Use ... to extend a slice inside another slice
	// Below will add elements of slc3 in slc9
	slc9 = append(slc9, slc6...)
	fmt.Println("SLC9: ", slc9,
		" | Length of slice: ", len(slc9),
		" | Capacity of slice: ", cap(slc9))

	// There are no predefined methods to remove element form slice,
	// but element slicing can be used to remove element
	// Remove 1st element
	slc9 = slc9[1:]
	fmt.Println("SLC9: ", slc9,
		" | Length of slice: ", len(slc9),
		" | Capacity of slice: ", cap(slc9))

	// Remove last element
	slc9 = slc9[:len(slc9)-1]
	fmt.Println("SLC9: ", slc9,
		" | Length of slice: ", len(slc9),
		" | Capacity of slice: ", cap(slc9))

	// Remove nth element from slice
	n := 2
	slc9 = append(slc9[:n], slc9[n+1:]...)
	fmt.Println("SLC9: ", slc9,
		" | Length of slice: ", len(slc9),
		" | Capacity of slice: ", cap(slc9))
}
