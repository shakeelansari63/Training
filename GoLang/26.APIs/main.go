package main

import (
	"fmt"
	"net/http"

	"26.APIs/controllers"
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
	router.HandleFunc("/course/{id}", controllers.GetCourseById).Methods("GET")
	router.HandleFunc("/course", controllers.AddNewCourse).Methods("POST")
	router.HandleFunc("/course/{id}", controllers.UpdateCourse).Methods("PUT")
	router.HandleFunc("/course/{id}", controllers.DeleteCourse).Methods("DELETE")

	// Start web server
	http.ListenAndServe(":4000", router)
}
