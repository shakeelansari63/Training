package models

type Course struct {
	Id     string  `json:"courseid"`
	Name   string  `json:"coursename"`
	Price  float32 `json:"price"`
	Author *Author `json:"author"`
}

type Author struct {
	Name    string `json:"authorname"`
	Website string `json:"website"`
}

func (course *Course) IsEmpty() bool {
	return course.Name == ""
}

func (course *Course) CheckNameExist(name string) bool {
	return course.Name == name
}
