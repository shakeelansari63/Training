// Working with Query Selector
// This return the node with masterhead class
console.log(document.querySelector(".masthead") );

// To get all nodes use QuerySelectorAll method
// This gives all anchor nodes
console.log(document.querySelectorAll("a") );

// Nesting search
// This find all anchor "a" inside element with class has-children inside class menu
console.log(document.querySelectorAll(".menu .has-children a"));

// Filter can be further drilled down to href
// This return node with a having link to linkedin.com
console.log(document.querySelector("a[href*='linkedin.com']"));

// Comma seperated list for multiple queries
console.log(document.querySelectorAll("menu li a, social-nav li a"));
