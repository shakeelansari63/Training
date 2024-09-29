package main08

import "fmt"

func main() {
	num := 6

	// If and Else follow if..else if..else ladder
	if num <= 5 {
		fmt.Println("Less than five")
	} else if num <= 10 {
		fmt.Println("Less than 10")
	} else {
		fmt.Println("Greater than 10")
	}

	// Nesting multiple checks
	// Use || (or) or && (and) operators to check multiple conditions

	if num <= 5 && num >= 2 {
		fmt.Println("Between 2 and 5")
	} else if num > 5 || (num < 2 && num >= 0) {
		fmt.Println("outside range")
	} else {
		fmt.Println("negative number")
	}

	// ! operator can be used to conver true to false or false to true
	fmt.Println("Not or True: ", !true, "Not of False: ", !false)

	// Go has concept of shot circuit
	// Meaning if multiple conditions are nested via ||
	// ,go will stop evaluation as soon as it find first true value and rest is not evaluated
	// because it is confirmed that whole expression will evaluate true
	// Similarlly for all &&, it stop evalueation as soon as first false is encountered
	// because it is certain that all expression is going to be false anyway

	// Another useful syntax with If in go is with initialized and check
	// For example we can have a map and we can get a key using ok syntax and check the ok variable
	// in same if statement
	mp := map[string]int{
		"key1": 10,
		"key2": 20,
		"key3": 30,
	}
	// Check
	if pop, ok := mp["key4"]; ok {
		// Pop and Ok variables are only defined in scope of this block
		fmt.Println("key4: ", pop) // We can also access pop variable here

		// So this gives us opportunity to redefine pop and ok in else block without error
	} else if pop, ok := mp["key2"]; ok {

		fmt.Println("key2: ", pop) // and use here
	} else {
		fmt.Println("no key")
	}

	// Switch Case work similar to C
	// But you don't need to break out
	switch num {
	case 1:
		fmt.Println("One")

	case 2:
		fmt.Println("Two")

	default:
		fmt.Println("None")
	}

	// Go allows to check multiple cases as once
	switch num {
	case 1, 3, 5:
		fmt.Println("one, three & five")
	case 2, 4, 6:
		fmt.Println("two, four & six")
	default:
		fmt.Println("none of the above")

	}

	// Like If, we can also have initializer in Switch and it is scoped only to switch
	switch num2 := (num / 2) + 3; num2 {
	case 1, 3, 5:
		fmt.Println("one, three & five")
	case 2, 4, 6:
		fmt.Println("two, four & six")
	default:
		fmt.Println("none of the above")
	}

	// Till now we have been checking for equality
	// But switch can also support inequalities
	switch {
	case num%2 == 0:
		fmt.Println("Even Number")
	case num%2 != 0:
		fmt.Println("Odd number")
	}

	// Go switch has implicit bread instead of implicit fallthrough in c
	// meaning we don't have to put break after each switch case
	// But if we have overlapping cases and we want it to fall through
	// we can use fallthrough keyword
	switch {
	case num <= 10:
		fmt.Println("Less than 20")
		fallthrough
	case num <= 20:
		fmt.Println("Less than 10")
	case num <= 5:
		fmt.Println("Less than 5")
	default:
		fmt.Println("Greater than 20")
	}

	// There is also a type switch which is often used in Go
	// We can check this for interface type which can accept any type of value
	var num3 interface{} = 2
	switch num3.(type) {
	case int, int8, int16, int32, int64:
		fmt.Println("integer")

		// Also break keword allow us to break early if needed
		if num3 == 1 {
			break
		}
		fmt.Println("This will be printed if num is not 1")

	case float32, float64:
		fmt.Println("float")

	case string:
		fmt.Println("string")

	default:
		fmt.Println("other type")
	}

}
