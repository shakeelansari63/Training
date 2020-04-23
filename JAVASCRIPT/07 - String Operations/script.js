var a = 5;
var b = "4";
var sum = a + b;
var sub = a - b;
var mul = a * b;
var div = a / b;

// Add operator convert number to string
console.log(sum)

// Whereas other arithmatic operators convert string to number
console.log(sub)
console.log(mul)
console.log(div)

// If string contain any other digit other than number, JS throws NaN (Not a Number) error
var something = a * "duck";
console.log(something)
