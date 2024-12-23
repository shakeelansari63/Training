package controllers

import (
	"encoding/json"
	"fmt"
	"net/http"

	"26.APIs/data"
	"26.APIs/models"
	"github.com/gorilla/mux"
)

func Initialize() {
	data.InitData()
}

// These are Controller helper methods to be used by router
func GoToHome(w http.ResponseWriter, r *http.Request) {
	fmt.Println("Route 'GET /' Called")
	w.Header().Set("Content-Type", "text/html")
	w.Write([]byte("<h2>Welcome to API with Go</h2>"))
}

// - GET /courses for all courses
func GetAllCourses(w http.ResponseWriter, r *http.Request) {
	fmt.Println("Route 'GET /courses' Called")
	w.Header().Set("Content-Type", "application/json")
	allCourses := data.GetAllCourses()

	// Return Json Data
	json.NewEncoder(w).Encode(allCourses)
}

// - GET /course/{id} for course by id
func GetCourseById(w http.ResponseWriter, r *http.Request) {
	fmt.Println("Route 'GET /course/{id}' Called")
	w.Header().Set("Content-Type", "application/json")
	vars := mux.Vars(r)
	id := vars["id"]
	if id != "" {
		course := data.GetCourseById(id)

		if course == nil {
			http.Error(
				w,
				"Error: No couurse found with given ID",
				http.StatusNotFound,
			)
			return
		}

		json.NewEncoder(w).Encode(course)
		return
	}

	// Return Json Data
	json.NewEncoder(w).Encode("Error: No couurse found with given ID")
}

// - POST /course for adding new course
func AddNewCourse(w http.ResponseWriter, r *http.Request) {
	fmt.Println("Route 'POST /course Called")
	w.Header().Set("Content-Type", "application/json")

	if r.Body == nil {
		http.Error(
			w,
			"Error: No data provided",
			http.StatusBadRequest,
		)
		return
	}

	var newCourse models.Course
	json.NewDecoder(r.Body).Decode(&newCourse)

	if newCourse.IsEmpty() {
		http.Error(
			w,
			"Error: No data provided",
			http.StatusBadRequest,
		)
		return
	}

	savedCourse := data.AddCourse(newCourse)

	if savedCourse == nil {
		http.Error(
			w,
			"Error: Unable to save Course",
			http.StatusInternalServerError,
		)
		return
	}

	json.NewEncoder(w).Encode(savedCourse)
}

// - PUT /course/{id} for updating course
func UpdateCourse(w http.ResponseWriter, r *http.Request) {
	fmt.Println("Route 'PUT /course/{id} Called")
	w.Header().Set("Content-Type", "application/json")

	vars := mux.Vars(r)
	cid := vars["id"]

	if cid == "" {
		http.Error(
			w,
			"Error: No course id provided",
			http.StatusBadRequest,
		)
		return
	}

	if r.Body == nil {
		http.Error(
			w,
			"Error: No data provided",
			http.StatusBadRequest,
		)
		return
	}

	var updatedCourse models.Course
	json.NewDecoder(r.Body).Decode(&updatedCourse)

	if updatedCourse.IsEmpty() {
		http.Error(
			w,
			"Error: No data provided",
			http.StatusBadRequest,
		)
		return
	}

	finalized := data.UpdateCourse(cid, updatedCourse)

	if finalized == nil {
		http.Error(
			w,
			"Error: Cannot update the course",
			http.StatusInternalServerError,
		)
		return
	}

	json.NewEncoder(w).Encode(finalized)
}

// - DELETE /course/{id} for deleting course
func DeleteCourse(w http.ResponseWriter, r *http.Request) {
	fmt.Println("Route 'DELETE /course/{id} Called")
	w.Header().Set("Content-Type", "application/json")

	vars := mux.Vars(r)
	cid := vars["id"]

	if cid == "" {
		http.Error(
			w,
			"Error: No course id provided",
			http.StatusBadRequest,
		)
		return
	}

	deletedCourse := data.DeleteCourseById(cid)

	if deletedCourse == nil {
		http.Error(
			w,
			"Error: Cannot delete course with provided ID",
			http.StatusInternalServerError,
		)
		return
	}
	json.NewEncoder(w).Encode(deletedCourse)
}
