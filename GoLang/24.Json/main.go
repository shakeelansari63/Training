package main

import (
	"encoding/json"
	"fmt"
)

type Course struct {
	Name     string   `json:"coursename"`     // This indicate name of field this field will be coursename when marshal'd into json
	Price    int      `json:"price"`          // This indicate name of field this field will be price when marshal'd into json
	Site     string   `json:"website"`        // This indicate name of field this field will be website when marshal'd into json
	Password string   `json:"-"`              // This indicate field will be removed when marshal'd into json
	Tags     []string `json:"tags,omitempty"` // This indicate name of field this field will be tags and nils will omited when marshal'd into json
}

func main() {
	// Lets tru to encode as Struct to Json String
	// This is equivalent to JSON.stringify
	EncodeToJson()
	DecodeJson()
}

func EncodeToJson() {
	fmt.Println("Lets work with Encoding Json Data")
	fmt.Println("")

	// Lets try to create an object of struct
	coursesList := []Course{
		{"React JS", 299, "LearnCodeOnline.in", "abc123", []string{"web", "js"}},
		{"Pythin", 399, "LearnCodeOnline.in", "def123", []string{"general", "py"}},
		{"Angular JS", 199, "LearnCodeOnline.in", "abcd12", nil},
		{"MERN", 299, "LearnCodeOnline.in", "qwe321", []string{"full-stack", "js"}},
	}

	// Lets try to print our Object
	fmt.Printf("Struct Obj: %+v\n", coursesList)

	// Now we have a slice of cources, lets try to marshal it into Json
	content, err := json.Marshal(coursesList)
	handleErr(err)
	fmt.Println("Json Content is:", string(content))

	// Now we notice all the Json data is in single line and it is not easy to read.
	// This is good for sending it to API, but not for human reading
	// Lets try to marshal it into something human readable form
	content, err = json.MarshalIndent(coursesList, "", "\t") // We are using Tab (\t) for indents
	handleErr(err)
	fmt.Println("Json Indented Content is:", string(content))

	// This is more human readable form.
	// And you will notice that field names are as we have mentioned with `json:` syntax in Struct
	// Also, Password field is ommited since we gave `json:"-"`
	// And Tag field for "Angular JS" course is ommited since it was Nil
}

func DecodeJson() {
	fmt.Println("Lets work with Decoding Json Data")
	fmt.Println("")
	// This is a sample Json Data
	jsonData := []byte(`
	{
		"coursename": "MERN",
		"price": 299,
		"website": "LearnCodeOnline.in",
		"tags": [
			"full-stack",
			"js"
		]
	}
	`)
	fmt.Println("Json Data is ", string(jsonData))

	// Lets check if it is a valid Json
	fmt.Println("Is json valid? -", json.Valid(jsonData))

	// Now lets Unmarshal the Json to a struct.
	// Remember the field names in json should match that of aliases we have set in struct
	var decodedStruc Course
	json.Unmarshal(jsonData, &decodedStruc)

	fmt.Printf("Decoded Struct - %+v", decodedStruc)

	//  Now we have struct and we can work with it as Go Object

	// But sometime there are times, we don't want to convert the incoming Json to struct
	// We may just want to convert it to Map of Key value pair
	// And access individual keys
	// And that can be done as follow
	var decodedMap map[string]interface{}
	json.Unmarshal(jsonData, &decodedMap)
	fmt.Printf("Decoded Map - %+v", decodedMap)

	// And since it is Map, we can loop over individual keys
	for k, v := range decodedMap {
		fmt.Printf("Key: %v, Value: %v, Value Type: %T\n", k, v, v)
	}
}

func handleErr(err error) {
	if err != nil {
		panic(err)
	}
}
