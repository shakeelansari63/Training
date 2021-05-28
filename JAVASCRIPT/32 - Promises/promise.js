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

// Since we are returning promise from addPost function, 
// we can use .then method on addPost to tell action on successful resolve
addPost({title: 'Post 3', body: 'Post Three'}).then(getPosts)

// we can set the error parameter and it will cause rejection in Promise causing it not tu run the then part
// If we wait anoter 3 sec and try to add new post but error occur in that post, getPosts will not call

// But you will see, we will have uncaught exception. So we should catch this exception with .catch
setTimeout( () => {
    someError = true;
    addPost({title: 'Post 4', body: 'Post Four'})
        .then(getPosts)
        .catch(err => console.log(err))
}, 3000);

// Promise.All is a way to wait for multiple promises and action after all are done
// Lets create multiple promises
const promise1 = Promise.resolve('Hello World!!!');
const promise2 = 10;
const promise3 = new Promise((resolve, reject) => {
    setTimeout(resolve, 5000, 'Good Bye');
});

// So promise.all tales list of promises
Promise.all([promise1, promise2, promise3])
    .then( (value) => console.log(value))

// If you use Fetch API to make API calls, you will have to make 2 .thens
// First will get HTTP response codes and headers
// Next will actually read the json 
setTimeout( () => {
    const promise4 = fetch('https://jsonplaceholder.typicode.com/users')
    const promise5 = fetch('https://jsonplaceholder.typicode.com/users').then( res => res.json())

    // For promise 4 we will see http response and for promise 5 we will see actual JSOn data
    Promise.all([promise4, promise5]).then( (value) => console.log(value))
}, 7000);