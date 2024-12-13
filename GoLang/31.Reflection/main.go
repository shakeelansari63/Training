package main

import (
	"fmt"
	"reflect"
	"regexp"
	"strconv"
	"strings"
)

// Reflection is a mechanism to deconstruct Go objects
// For example lets say we have a Struct
// This struct has some mix of data types and some custom struct tags
type User struct {
	Name  string `validate:"required,min=2"`
	Email string `validate:"required,email"`
	Age   int    `validate:"min=0,max=120"`
}

// Lets create a method where we can deconstruct the object and see individual parts
// And also use custom validate tag to validate teh struct data
func validate(u interface{}) error {
	// Following will deconstruct the object
	v := reflect.ValueOf(u)
	// Lets see what is in this variable
	fmt.Printf("\n>> Deconstructed: %+v\n", v)

	// We can loop over individual fileds of this deconstructed object using NumFileds
	for i := 0; i < v.NumField(); i++ {
		// And we can access each field with Field method and giving index
		field := v.Type().Field(i)
		fmt.Printf("Field: %+v\n", field)

		// We can get type and name of each files along with Tag
		value := v.Field(i)
		fieldName := field.Name
		fieldType := value.Kind()
		tags := field.Tag
		fmt.Println("Name:", fieldName, "Type:", fieldType, "Tags:", tags, "Value:", value)

		// Lets Perform the validations
		// Extract all rules from validate tags
		for _, rule := range strings.Split(tags.Get("validate"), ",") {
			switch {
			case strings.HasPrefix(rule, "min=") && fieldType == reflect.Int:
				minval, _ := strconv.Atoi(strings.TrimPrefix(rule, "min="))
				if int(value.Int()) < minval {
					return fmt.Errorf("%s must not be less than %d", fieldName, minval)
				}

			case strings.HasPrefix(rule, "max=") && fieldType == reflect.Int:
				maxval, _ := strconv.Atoi(strings.TrimPrefix(rule, "max="))
				if int(value.Int()) > maxval {
					return fmt.Errorf("%s must not be greater than %d", fieldName, maxval)
				}

			case strings.HasPrefix(rule, "min=") && fieldType == reflect.String:
				minval, _ := strconv.Atoi(strings.TrimPrefix(rule, "min="))
				if len(value.String()) < minval {
					return fmt.Errorf("%s length must not be less than %d", fieldName, minval)
				}

			case strings.HasPrefix(rule, "max=") && fieldType == reflect.String:
				maxval, _ := strconv.Atoi(strings.TrimPrefix(rule, "max="))
				if len(value.String()) > maxval {
					return fmt.Errorf("%s length must not be greater than %d", fieldName, maxval)
				}

			case rule == "required":
				if value.String() == "" {
					return fmt.Errorf("%s cannot be nil", fieldName)
				}

			case rule == "email":
				emailRegex := regexp.MustCompile(`^[a-zA-Z0-9._%+\-]+@[a-zA-Z0-9.\-]+\.[a-z]{2,4}$`)
				if !emailRegex.MatchString(value.String()) {
					return fmt.Errorf("%s should be valid email", fieldName)
				}
			}
		}
	}

	return nil
}

func main() {
	// Lets create and object
	invalidUser := User{
		Name:  "Shakeel",
		Email: "abc.com",
		Age:   32,
	}

	// Lets validate the invalidUser
	if err := validate(invalidUser); err != nil {
		fmt.Println("!!! Error -", err)
	}

	// Now lets try more validations
	invalidUser2 := User{
		Name:  "S",
		Email: "a@abc.com",
		Age:   31,
	}
	if err := validate(invalidUser2); err != nil {
		fmt.Println("!!! Error -", err)
	}

	// Now lets try more validations
	invalidUser3 := User{
		Name:  "Shakeel",
		Email: "a@abc.com",
		Age:   131,
	}
	if err := validate(invalidUser3); err != nil {
		fmt.Println("!!! Error -", err)
	}

	// And finally a valid
	validUser := User{
		Name:  "Shakeel",
		Email: "a@abc.com",
		Age:   34,
	}
	if err := validate(validUser); err != nil {
		fmt.Println("!!! Error -", err)
	}
}
