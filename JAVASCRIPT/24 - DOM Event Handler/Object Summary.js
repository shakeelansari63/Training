// Get the node
const CTA = document.querySelector('.cta a')

// Event handler function  function with with action
// e argument is event and can be used to disable default behaviour
function toggleColour(e){

    // Disable default behaviour of link to go to address
    e.preventDefault();

    // Toggle Colour
    if (CTA.style.color == 'green') {
        CTA.style='';
    } else {
        CTA.style.color = 'green';
    }
}

// Link handler with event
CTA.onclick = toggleColour;


// Event Handler can perform only 1 action at a time. So if we create 2 functions above as
// function action2() { console.log('event occured')}
// and bind both functions to onclick
// CTA.onclick = toggleColour;
// CTA.onclick = action2;
// The 2nd event takes presedence and breaks the functionality.
// To handle this we use event listners instead of event handlers.
const HOME = document.querySelector('.masthead li a')

function toggleHome(e) {
    e.preventDefault();

    if (HOME.style.color == 'red') {
        HOME.style = '';
    } else {
        HOME.style.color = 'red';
    }
}
HOME.addEventListener("click", toggleHome, false);
// And we can add mode actuons with anonymous function
HOME.addEventListener("click", function() {console.log('Home clicked');}, false);

// To pass arguments on event listener action,
// we can utilize the anonymous functions as there is no direct way to do it
const ABOUT = document.querySelectorAll('.masthead li')[5].querySelector('a');
// Action function
function aboutText(e, current) {
    e.preventDefault();

    current.innerHTML == 'About' ? current.innerHTML = 'Me' : current.innerHTML = 'About';
}
// Add Listener on click
// In order to access event, the e variable will be passed from function to inside function
// and then called
ABOUT.addEventListener('click',function(e) {aboutText(e, this);}, false);
