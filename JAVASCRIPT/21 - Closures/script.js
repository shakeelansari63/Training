// Usually once a function is executed, the variables in scope of function are no loger available.
// As in below example a, b and sum
function doSomeMath() {
	var a = 5;
	var b = 4;
	var sum = a + b;

	return sum;
}

var theResult = doSomeMath();

console.log("The result: ", theResult);

// But consider this. The function inside a fucntion which uses the variables defined inside parent function
function doMultiply() {
	var a = 5;
	var b = 4;

	function multiply() {
		var result = a * b;
		return result;
	}

	return multiply;
}

var mulResult = doMultiply();

// Since the function rreturns a function, the output will be function
console.log("The result: ", mulResult);

// In order to get value, we call the function
console.log("The result: ", mulResult());

// So we ca see, the variables a and b are not discarded, they are retained sicne multiply function depends on them
