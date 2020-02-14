from pymongo import MongoClient
import datetime

# Build Connection to Database Server
# dnspython is required for srv connection string
username = '<changeit>'
password = '<changeit>'
clustername = '<changeit>mongo'
cli = MongoClient(f'mongodb+srv://{username}:{password}@{clustername}-szsga.mongodb.net/test?retryWrites=true&w=majority')

# Select Working Database
db = cli["mydb"]

# Select Working Table
collection = db["mycollection"]

# Drop table
db.drop_collection("mycollection")

# Insert one Document
collection.insert_one({
    '_id': 'my_unique_id_1',
    'title': "Post 1",
    'body': "Post 1 Body",
    'timestamp': datetime.datetime.now()
})