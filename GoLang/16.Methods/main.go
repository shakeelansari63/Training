package main

import "fmt"

type User struct {
	Name  string
	Age   int
	Email string
}

func main() {
	// Methods are special functions which can be called from Struct
	// Unlike other languages, Methods are not defined inside struct/class
	// But they are defined outside by passing object of struct
	// Lets try to create an object of the user struct
	usr := User{
		"Shakeel",
		31,
		"shakeel@go.dev",
	}

	fmt.Println("User name is:", usr.Name, "And email is", usr.Email)

	// Now for method definition, see outside main function
	// Lets use the greet method form user object
	usr.Greet()

	// Though the struct methods have access to the struct members.
	// They have access to copy of object and not actual object
	// So, if we update any parameter in these methods, they are not changed in actual object
	// This will print new Email
	usr.UpdateEmail()

	// But this will print the same existing email
	usr.Greet()
}

// This is a method of User struct and can be called from User's object
func (u User) Greet() {
	fmt.Printf("Hello I am %v. I am %v years old and my email is %v\n", u.Name, u.Age, u.Email)
}

func (u User) UpdateEmail() {
	u.Email = "test@go.dev"
	fmt.Println("New email is - ", u.Email)
}
