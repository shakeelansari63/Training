// Create constant value
const PI = 3.1415;

// print it
console.log(PI);

// It we try to change the constant, it throws error
//PI = 22/7;

// Let is Block Scope meaning, a varible defined in block (if, loop, function) is for that scope
function localScope(){
    var a = 2;
    if (a){
        var a = 5;
        console.log("Inside If a = ", a);
    }
    console.log("Inside function a = ", a);
}

function blockScope(){
    let a = 2;
    if (a){
        let a = 5;
        console.log("Inside If a = ", a);
    }
    console.log("Inside function a = ", a);
}

localScope();
blockScope();
