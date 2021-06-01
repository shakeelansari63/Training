# Run in Mongo Shell
mongo -u root -p root <<-EO
// List all Dbs in System
show dbs

// Use specific Database, this will create db if it does not exist
use localtest

// List all collections on the DB
show collections

// If collection does not exist, then create collection
db.createCollection('posts')

// See all collections again
show collections

// Insert sample 1 document in Colection
db.posts.insert({
    name: 'Post One',
    body: 'Body of Post 1',
    likes: 5,
    tags: ['News' , 'Events'],
    publish: Date(),
})

// Insert more sample documents in Collection
db.posts.insertMany([
    {
        name: 'Post Two',
        body: 'Body for Post 2',
        likes: 6,
        tags: 'News'
    },
    {
        name: 'Post Three',
        body: 'Body for Post 3',
        likes: 12,
        tags: 'Events'
    },
    {
        name: 'Post Four',
        body: 'Body for Post 4',
        likes: 2,
        tags: 'Sports'
    },
])

// See all documents in Posts collection
db.posts.find()

// See posts in human readable form
db.posts.find().pretty()

// Find all News Tags Documents
db.posts.find( {tags: 'News'} ).pretty()

// Find only 1 post 
db.posts.findOne( {tags: 'News'} )

// To get only few fields instead of all fields, use projection list in find
db.posts.find(
    {name: 'Post One'},
    {name: 1, publish:1}
).pretty()

// If we want to project every field except comments
db.posts.find(
    {name: 'Post One'},
    {comments: 0}
).pretty()

// Sort data by likes descending
db.posts.find({ tags: 'News' }).sort({likes: -1}).pretty()

// print only title of each post
// We can use Javascript Anonymous or arrow functions
db.posts.find().forEach( (post) => {
    print('Title: ' + post.name)
} )

// Update Whole Post 2 Document
db.posts.update(
    {name: 'Post Two'},
    {
        name: 'Post Two',
        body: 'Updated Body for Post 2',
        tags: ['News', 'Sports']
    }, 
    { upsert: true}
)

// See updated Posts
db.posts.find().pretty()

// Update Only selected fields using $set operator
db.posts.update(
    {name: 'Post Three'},
    {
        $set: {
            publish: Date(),
            tags: ['Events', 'Technology']
        }
    }
)

// Check Post Three
db.posts.find({name: 'Post Three'}).pretty()

// Increment the likes on post 4 by 2
db.posts.update(
    {name: 'Post Four'},
    {
        $inc: {
            likes: 2
        }
    }
)

// Check updated data
db.posts.find({name: 'Post Four'}).pretty()

// Rename Likes field to Views in Post 1
db.posts.update(
    {name: 'Post One'},
    {
        $rename: {
            likes: 'views'
        }
    }
)

// See the renamed data
db.posts.findOne({name: 'Post One'})

// delete Post 4
db.posts.remove({name: 'Post Four'})

// See all posts
db.posts.find().forEach(
    (post) => {
        print(post.name)
    }
)

// Mongo DB can have nested document meaning a dcument in document
// Lets add Comments Document for post 1, post 2 and post 3
db.posts.update(
    {name: 'Post Two'},
    {
        $set: {
            comments: [
                {
                    user: 'Mary',
                    comment: 'Nice Post',
                    date: Date()
                },
                {
                    user: 'William',
                    comment: 'Average',
                    date: Date()
                },
                {
                    user: 'Chris',
                    comment: 'Fab',
                    date: Date()
                }
            ]
        }
    }
)

db.posts.update(
    {name: 'Post Three'},
    {
        $set: {
            comments: [
                {
                    user: 'William',
                    comment: 'Good',
                    date: Date()
                },
                {
                    user: 'Chris',
                    comment: 'Meh',
                    date: Date()
                }
            ]
        }
    }
)

db.posts.update(
    {name: 'Post One'},
    {
        $set: {
            comments: [
                {
                    user: 'Mary',
                    comment: 'Well Done',
                    date: Date()
                },
                {
                    user: 'William',
                    comment: 'Seriously',
                    date: Date()
                }
            ]
        }
    }
)

// See the Post 2
db.posts.findOne({name: 'Post Two'})

// If we want to search in Sub Document (Comments), we can sue $elemMatch
// This should return post 1 and 2
db.posts.find({
    comments: {
        $elemMatch: {
            user: 'Mary'
        }
    }
}).pretty()

// In order to search, we must create an index first
// Lets create index of type text on name field
db.posts.createIndex({name: 'text'})

// See all indexes on collection
db.posts.getIndexes()

// Now lets search on this text field
// Following returns Post 2 and 3 since they both have Post T
db.posts.find({
    $text: {
        $search: '"Post T"'
    }
}).pretty()

// We can search by Greater than or Less than checks
db.posts.find({
    likes: { $gt: 3}
}).pretty()

// Push new Tags in post Two
db.posts.update(
    {name: 'Post Two'},
    {
        $push: {
            tags: 'Technology'
        }
    }
)

db.posts.update(
    {name: 'Post Two'},
    {
        $pull: {
            tags: 'Events'
        }
    }
)

// See Tags of Post 2
db.posts.find(
    {name: 'Post Two'},
    {tags: 1}
).pretty()

// Drop collection
db.posts.drop()

// Create a new Capped Collection
db.createCollection('cappedPost', {capped: true, size: 6142800, max: 3000})

// Now check Stats of caped collection
db.cappedPost.stats()

// Drop Capped Collection
db.cappedPost.drop()

// Drop Database
db.dropDatabase()

EO