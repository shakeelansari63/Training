// Javascript objects are different than other classes

// This created a class object
var obj = new Object();

// Object Properties
obj.name = "Some Name";
obj.age = 21;
obj.sex = "M";
obj.job = "Some Job";
obj.is_dead = false;

// Object methods
obj.changeName = function(newName){
    obj.name = newName;
}

obj.grow = function(){
    obj.age ++;
}

// Display Object
console.log(obj.name);
console.log(obj.age);
obj.changeName("New Name");
obj.grow();
console.log(obj.name);
console.log(obj.age);

// This can be encapsulated in JSON
var obj_json = {
    // Properties
    name: "Old name",
    age: 18,
    sex: "F",
    job: "Old Job",
    isDead: false,

    // Methods
    changeName: function(newName){
        obj_json.name = newName;
    },

    grow: function(){
        obj_json.age ++;
    }
}
console.log(obj_json.name);
console.log(obj_json.age);
obj_json.changeName("New Name");
obj_json.grow();
console.log(obj_json.name);
console.log(obj_json.age);
