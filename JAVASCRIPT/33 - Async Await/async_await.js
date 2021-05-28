// Lets start with a hypothetical post service
const posts = [
    {title: 'Post 1', body: 'Post One'},
    {title: 'Post 2', body: 'Post two'}
]

// We can get all the posts but it take about 1 second So we set timeout of 1000ms to simulate this
function getPosts() {
    setTimeout(() => {
        let output = '';

        //Append all posts titles to output in a list
        posts.forEach((post) => {
            output += `<li>${post.title}</li>`;
        });

        // And we set the Body of HTML with this
        document.body.innerHTML = output;
    }, 1000);
}

// Simulate error handling 
let someError = false;

//And there We can add a post but it takes 2 second
// Just like we saw in Callback
function addPost(post) {
    // This addPost will return a promise object which can either be successful or fail
    // Promise take get 2 values resolve is success and reject is failure
    return new Promise( (resolve, reject) => {
        // And our app works here
        setTimeout( () => {
            posts.push(post);
            
            // Check if error occured
            if (someError) {
                // If error happen
                reject('Error: Something went wong');
            } else {
                // If successful
                resolve()
            }

        }, 2000);
    });
}

// Async and Await are elegant way to handle promises.
// No need to have .them methods. 
// You have to use async before function if you want to use await
async function init() {
    // Await will wait for resolved promise
    await addPost({title: 'Post 3', body: 'Post Three'})

    // And we can simply call next method
    getPosts()
}

setTimeout(init, 1);

// It also works with fetch API
async function fetchUsers() {
    const res = await fetch('https://jsonplaceholder.typicode.com/users')

    // We know the promise returned by fetch is HTTP response, so to get data we have to do another await
    const users = await res.json()

    console.log(users)
}

setTimeout(fetchUsers, 3000);