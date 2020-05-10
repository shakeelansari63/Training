// Whole browser window is an object for java script - BOM (Browser Object Model)
// Highest level of obejct in BOM is window
// e.g. Width of window
console.log(window.innerWidth);

// Open new tab
// window.open()

// Documnet is HTML inside window - DOM (Document Object Model)
// Documents can be access by window.document
console.log(window.document);

// Or in short by just document
console.log(document);

// Query Selector
// A Node can be selected using query Selector
// This return first element if there are multipel nodes satusfying condition
let node = document.querySelector('.masthead li');
console.log(node);

// This return all nodes in an array
let node2 = document.querySelectorAll('.masthead li');
console.log(node2);

// Access the inner html of a Node
console.log(node.innerHTML);

// Access HTML with node
console.log(node.outerHTML);

// Access Node attributes
// This checks whether attribute exits
node = document.querySelector('.masthead li a')
console.log(node.hasAttribute('href'));

// This get the value of attribute
console.log(node.getAttribute('href'));

// This sets the attribute value
node.setAttribute('href', '#home');
console.log(node.getAttribute('href'));

// Get list if classes in node
let node3 = document.querySelector('.masthead');
console.log(node3.classList);

// Add Class
node3.classList.add('custom-class');
console.log(node3.classList);

// Remove class
node3.classList.remove('clear');
console.log(node3.classList);

// Get id of Node
console.log(node3.id);

// Creating new child elements of a node

// Select a node`
let node4 = document.querySelector('.masthead ul');
// Create a node
let liNode = document.createElement('li');
// Create text node
let liText = document.createTextNode('Loop back');
// Put text node inside new element
liNode.appendChild(liText);
// Put new element inside existing node
node4.appendChild(liNode);
