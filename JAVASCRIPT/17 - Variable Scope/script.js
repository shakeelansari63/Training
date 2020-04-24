function findBiggestFraction(a,b) {
    console.log("Fraction a: ", firstFraction);
    console.log("Fraction b: ", secondFraction);

    var result; // Local Scope

	a>b ? result = ["a",a] : result = ["b",b];
    return result;
}

var firstFraction = 7/16; // Global Scope
var secondFraction = 13/25; // Global Scope

var fractionResult = findBiggestFraction(firstFraction,secondFraction);
console.log("Fraction " + fractionResult[0] + " with a value of " + fractionResult[1] + " is the biggest.");

// This gives error since result is not defied in global Scope
console.log(result);
