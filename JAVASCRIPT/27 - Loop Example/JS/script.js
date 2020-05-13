// Lets try to loop over all external links in document
var eLinks = document.querySelectorAll('a[href^=http]') // Find all a tags where href start with http

for (var link of eLinks) {
    console.log(link);
}

// We can add Target attribute in these external links

for (var link of eLinks) {
    if (!link.hasAttribute('target')) {
        link.setAttribute('target', '_blank')
    }
}
