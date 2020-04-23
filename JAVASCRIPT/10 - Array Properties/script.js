var pens;
pens = ["red", "blue", "green", "orange"];

console.log("Before: ", pens);

// PROPERTIES:
// Get a property of an object by name:
console.log("Array length: ", pens.length);

// METHODS:
// Reverse the array:
pens.reverse();
console.log(pens);

// Remove the first value of the array:
pens.shift();
console.log(pens);

// Add comma-separated list of values to the front of the array:
pens.unshift("purple", "orange");
console.log(pens);

// Remove the last value of the array:
pens.pop();
console.log(pens);

// Add comma-separated list of values to the end of the array:
pens.push("pink", "prussian blue", "red");
console.log(pens);

// Find the specified position (pos) and remove n number of items from the array. Arguments: pens.splice(pos,n):
var pos = 2 // Starting from position 2
var n = 1 // 1 element will be removed
pens.splice(pos, n) // Starts at the seccond item and removes two items.
console.log(pens);

// Create a copy of an array. Typically assigned to a new variable:
var newPens = pens.slice();
console.log("New pens: ", newPens);

// Return the first element that matches the search parameter after the specified index position. Defaults to index position 0. Arguments: pens.indexOf(search, index):
var search = "red"; // Searching element Red
var index = 0; // Starting form 1st element
var result = pens.indexOf(search, index);
console.log("The search result index is: ", result);

// Return the items in an array as a comma separated string. The separator argument can be used to change the comma to something else. Arguments: pens.join(separator):
var separator = ","; // Making comma seperated list. Comma is default if no seperator passed
var arrayString = pens.join(separator);
console.log("String from array: ", arrayString);

// MDN documentation for Array:
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array
