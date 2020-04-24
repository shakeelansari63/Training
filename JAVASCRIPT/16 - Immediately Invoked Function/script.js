var a = 3/4;
var b = 15/9;

// This is executed as soon as it is seen by browser
// hence it necessary that variables used to be defined before
var theBiggest = (function(a,b) {
    var result;
    a>b ? result = ["a", a] : result = ["b", b];
    return result;
})(a, b)

console.log(theBiggest);
