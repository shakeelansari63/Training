var i = 1;
var reps = 0;

// While Loop
while (i < 567) {
    ++reps;
    console.log(reps + " reps gives us " + i)
    i *=2.1
}

// To ensure the loop run atleast one use do while Loop
i = 567
reps = 0
do {
    ++reps;
    console.log(reps + " reps gives us " + i)
    i *=2.1
} while(i < 567)

// For loop for known known number of iterations
for (i = 1, reps = 0; i<567; i*=2.1) {
    ++reps;
    console.log(reps + " reps gives us " + i)
}

// For Loop on Array using of
var ar = [1, 4, 6, 9, 15, 20, 31]
for (var a of ar) {
    console.log(a);
}

// For loop on object using in
var obj = {'a': 1, 'b':4, 's': true, 'd': false, 'k':'bee'}
for (var a in obj) {
    console.log(a + ' : ' + obj[a]);
}
