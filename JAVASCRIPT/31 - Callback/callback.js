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

//And there We can add a post but it takes 2 second
function addPost(post) {
    setTimeout( () => {
        posts.push(post)
    }, 2000);
}

// So if we call Add Post and then get Post, we won't be able to see latest post though we add before get
// Remove comment from following 2 lines
// addPost({title: 'Post 3', body: 'Post Three'});
// getPosts();

// The reason for this is, add post take 2 sec where as getPost takes 1 sec. By the time post is added, getPost has executed
// And DOM is prepared
// So here we can use callback. Callback is called when something is complete. And we can add getPost ad callback in add Post
function addPostCB(post, callback) {
    setTimeout( () => {
        posts.push(post);
        callback();
    }, 2000);
}

// Add post with getPost as callback function
addPostCB({title: 'Post 3', body: 'Post Three'}, getPosts);