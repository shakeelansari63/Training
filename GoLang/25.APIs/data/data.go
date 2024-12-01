package data

import (
	"25.APIs/models"
	"github.com/google/uuid"
)

var courses []models.Course = []models.Course{}

// Add dummy data
func InitData() {
	courses = append(courses, models.Course{
		Id:    uuid.NewString(),
		Name:  "React JS",
		Price: 249.99,
		Author: &models.Author{
			Name:    "Hitesh",
			Website: "lco.dev",
		},
	})

	courses = append(courses, models.Course{
		Id:    uuid.NewString(),
		Name:  "Angular JS",
		Price: 299.99,
		Author: &models.Author{
			Name:    "Hitesh",
			Website: "learncodeonline.in",
		},
	})
}

func GetAllCourses() *[]models.Course {
	return &courses
}

func GetCourseById(id string) *models.Course {
	for _, course := range courses {
		if course.Id == id {
			return &course
		}
	}
	return nil
}

func AddCourse(newCourse models.Course) *models.Course {
	// Check if course with same name already exist
	for _, course := range courses {
		if course.Name == newCourse.Name {
			return nil
		}
	}

	// Create new Id
	newCourse.Id = uuid.NewString()

	// Add course to list
	courses = append(courses, newCourse)

	return &newCourse
}

func UpdateCourse(cid string, courseToUpdate models.Course) *models.Course {
	// Check if Course Exist
	for idx, course := range courses {
		if course.Id == cid {
			courseToUpdate.Id = cid

			// Remove the course at this index
			courses = append(courses[:idx], courses[idx+1:]...)

			// Add Updated Course
			courses = append(courses, courseToUpdate)

			return &courseToUpdate
		}
	}

	return nil
}

func DeleteCourseById(cid string) *models.Course {
	for idx, course := range courses {
		if course.Id == cid {
			// Remove the course at this index
			courses = append(courses[:idx], courses[idx+1:]...)

			return &course
		}
	}

	return nil
}
