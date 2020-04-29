// Here is one object. But this cannot be reused to create new object.
// To do this, we need to create a constructor
var course = new Object();

var course = {
    title: "JavaScript Essential Training",
    instructor: "Morten Rand-Hendriksen",
    level: 1,
    published: true,
    views: 0,
    updateViews: function() {
        return ++course.views;
    }
}

console.log(course);

// Building constructor
function Course(title, instructor, level, published, views) {
    // Properties
    this.title = title;
    this.instructor = instructor;
    this.level = level;
    this.published = published;
    this.views = views;

    // Methods
    this.updateViews = function() {
        return ++this.views;
    }
}

// Create instance of Object Constructior
var course2 = new Course('New Cource Name', 'Instructor Unknown', 5, false, 0);
var course3 = new Course('Python basics', 'Unknown', 1, true, 5);

console.log(course2);
console.log(course3);

// We can also have list of objects
var courses = [
    new Course('Course 1', 'Instructor 1', 1, false, 0),
    new Course('Course 2', 'Instructor 2', 4, true, 10),
    new Course('Course 3', 'Instructor 3', 2, false, 0),
];

console.log(courses);
console.log(courses[1].updateViews())
