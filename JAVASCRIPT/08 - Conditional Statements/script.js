var a = 5;
var b = 5;
var theNumbersMatch;

// Match value only
if ( a == b ) {
    theNumbersMatch = true;
} else {
    theNumbersMatch = false;
}
console.log(theNumbersMatch);
// If you change 2nd varibale to string the condition still works

a = 5;
b = "5";

// Match value only
if ( a == b ) {
    theNumbersMatch = true;
} else {
    theNumbersMatch = false;
}
console.log(theNumbersMatch);

// So for strict check, === sign can be used
if ( a === b ) {
    theNumbersMatch = true;
} else {
    theNumbersMatch = false;
}
console.log(theNumbersMatch);

// Similarly <, >, <=, >=, != and !== can be used for checks

// Conditions can be nested with AND (&&) and OR(||) operators
a = 5;
b = 10;
var c = 2;
if ( a < b && a > c) {
    console.log("a is between b and c");
} else {
    console.log("a is not between b and c");
}

// Ternary Operators ae shorthand of if statement
// (condition) ? Statement if true : Statement if false

(a == b) ? console.log("Equal") : console.log("Not Equal");
// Can also be grouped
console.log( (a == b) ? "Equal" : "Not Equal");
