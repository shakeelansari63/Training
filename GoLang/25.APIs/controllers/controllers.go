package controllers

import (
	"encoding/json"
	"fmt"
	"net/http"

	"25.APIs/data"
)

func Initialize() {
	data.InitData()
}

// These are Controller helper methods to be used by router
func GoToHome(w http.ResponseWriter, r *http.Request) {
	fmt.Println("Route 'GET /' Called")
	w.Write([]byte("<h2>Welcome to API with Go</h2>"))
}

// - GET /courses for all courses
func GetAllCourses(w http.ResponseWriter, r *http.Request) {
	fmt.Println("Route 'GET /courses' Called")
	allCourses := data.GetAllCourses()

	// Return Json Data
	json.NewEncoder(w).Encode(allCourses)
}
