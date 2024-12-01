package main

import (
	"fmt"
	"net/http"

	"25.APIs/controllers"
	"github.com/gorilla/mux"
)

func main() {
	fmt.Println("Starting Web server")

	// Initialize some data
	controllers.Initialize()

	// Create Routes
	router := mux.NewRouter()
	router.HandleFunc("/", controllers.GoToHome).Methods("GET")
	router.HandleFunc("/courses", controllers.GetAllCourses).Methods("GET")

	// Start web server
	http.ListenAndServe(":4000", router)
}
