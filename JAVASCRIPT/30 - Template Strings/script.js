// Traditionally, strings were concatenates and written with + symbol which is difficult to format.
// ES6 solve this by template literals / template strings
var a = 12;
var b = 4;

console.log(a + ' divided by ' + b + ' is ' + (a/b) + '.');

// can also be written as
console.log(`${a} divided by ${b} is ${a/b}.`);
