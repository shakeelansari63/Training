package main

import (
	"fmt"
	"reflect"
)

// Structs are collection of data types
type MyStruct struct {
	id      int `required max: 999`
	name    string
	friends []string
}

// Struct does not support inheritance
// But it suppport composition
// here we have embedded MyStruct in MyStruct2
// So we can access all elemnets of MyStruct from object of MyStruct2
type MyStruct2 struct {
	MyStruct
	age int
}

func main() {
	// Maps & Stricts
	fmt.Println("----- Maps & Structs -----")

	// Maps
	// Maps are like dictionaries but with fixed key type and fixed value type
	// Unlike Array or Slice, maps are not ordered
	mp1 := map[string]int{
		"key1": 10,
		"key2": 20,
		"key3": 30,
	}
	fmt.Println("Sample Map: ", mp1)

	// Key has varied options for data type where as All data types can be used as value
	// Eg. All Integers, Floats and strings can be used as Key
	// Array can be used as key but slice cannot be used as key

	// Maps can also be created using make function
	// Values can be added by just assigninging value to key
	mp2 := make(map[string]int)
	mp2["k1"] = 2
	mp2["k2"] = 7
	fmt.Println(mp2)

	// Maps individual values can be extracted using corresponding keys
	fmt.Println("K2 element of mp2 is: ", mp2["k2"])

	// Delete values using delete function
	delete(mp1, "key2")
	fmt.Println("Sample Map: ", mp1)

	// If we try to select a key from map which does not exist, it won't return error
	// Instead it return default value for value type
	getKey2 := mp1["key2"]
	fmt.Println("Key 2 value: ", getKey2)
	// But we know key 2 does not exist in map. So in order to chek whether key2 exist in map
	// or it doesn't we can use ,ok syntax and get return code in boolean
	getkey2, ok := mp1["key2"]
	fmt.Println("Key 2 value: ", getkey2, "|", ok) // Here ok=false tells the key did not exist

	// Len function can be used to get length of map
	fmt.Println("Length of map1 is: ", len(mp1))

	// Maps are call be reference, so any change in 2nd map will affect first
	mp3 := mp1
	mp3["key7"] = 32
	fmt.Println("MP3: ", mp3, "\nMP1:", mp1)

	// Lets use the struct defined outside
	st1 := MyStruct{
		id:   1,
		name: "Dino",
		friends: []string{
			"Milo",
			"Jeff",
		},
	}
	fmt.Println(st1)

	// Individual element can be accessed via dot(.) syntax
	fmt.Println("Name of st1: ", st1.name)

	// If we want more details of Struct, we can use %+v with Printf. It also returns keys os structs
	fmt.Printf("%+v\n", st1)

	// In above exampel we declared teh struct outside and we can create any objects of taht struct
	// But if we are just going to create 1 instance we can create anonymous struct
	st2 := struct {
		name string
		age  int
	}{
		name: "Shaw",
		age:  32,
	}
	fmt.Println(st2)

	// Structs are Value type
	// Meaning if we assign the struct to another variable, it creates a copy
	// And passing it in fuction also create a copy

	// Lets try composition
	st3 := MyStruct2{}
	st3.id = 2
	st3.name = "Julie"
	st3.friends = []string{"Dino", "Jeff"}
	st3.age = 21
	fmt.Println(st3)

	//Though output look a wierd since MyStruct is inside its braces, we can still access
	// all elements with . syntax
	fmt.Println("name: ", st3.name, "age: ", st3.age)

	// There is a way to tag the fields in struct which is just loke comments
	// And that canbe used for validations
	// Use reflect package to get the tags
	// In MyStruct's id column `required max:999` is a tag
	t := reflect.TypeOf(MyStruct{})
	field, _ := t.FieldByName("id")
	fmt.Println("id tag: ", field.Tag)

}
