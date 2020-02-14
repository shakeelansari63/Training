# Install the Mongo DB on Hadoop Node.  
You can use MongoDB Ambari Stack - [Here](https://github.com/nikunjness/mongo-ambari)  
```console
cd /var/lib/ambari-server/resources/stacks/HDP/2.X/services/
git clone https://github.com/nikunjness/mongo-ambari.git
service ambari restart
```  
  
And follow the Ambari UI to install Mondo DB on Cluster  
  
# Or install Mongodb in Docker  
Using the DockerCompose file kept here  

## Start MongoDB
```sh
docker-compose -f ./docker-compose.yml up -d
```
  
## Stop MongoDB
```sh
docker-compose -f ./docker-compose.yml down
```
  
# Install Python Mongo DB connector "pymongo" and Object-Document Mapper (ODM) "mongoengine"  
```console
pip install -r ./requirements.txt
```
  
# RDBMS vs Document Design  
## RDBMS model  
![RDBMS](https://github.com/shakeelansari63/Training/blob/master/MONGODB/img/RDBMS%20Model.png)
  
## Document DB Model
![DOCDB](https://github.com/shakeelansari63/Training/blob/master/MONGODB/img/DocDB%20Model.png)
  
# How ODM Work
![ODM](https://github.com/shakeelansari63/Training/blob/master/MONGODB/img/ODM.png)
  
# Invoke MongoDB Shell
```console
mongo
```
  
# Basic Operation from Mongo Shell
### List Databases
```
show dbs
```
  
### Use a Database
```
use dbname
```
  
### Drop Database
```
use dbname
db.dropDatabase()
```
  
### Create new Database
```
use newdbname
```
This will create database and switch to it
  
### List collection in current database
```
show collections
```
  
### Create Collection in Current Database
```
db.createCollection('collectionname')
```
  
### Drop a collection
```
db.collectionname.drop()
```

### Insert single document in collection
```
db.collectionname.insert({
    field1: 'some string value',
    field2: somenumber,
    filed3: [some list of values],
    field4: {
        subfield1: 'another string',
        subfield2: Date()
    }
})
```
  
### Insert multiple documents in collection
```
db.collectionname.insertMany([
{
    field1: 'string',
    field2: number
},
{
    field1: 'string2',
    field2: number2
},
{
    field1: 'string',
    field3: true
}
])
```
  
### Find all items in Collection
```
db.collectionname.find()
```
#### Pretty method can make it more human readabale
```
db.collectionname.find().pretty()
```
  
### Filter 
```
db.collectionname.find({ field : value }).pretty()
```
  
### Sorting output
```
db.collectionname.find().sort({ field: 1})
```
Inside sort value 1 is for ascending and -1 fro descending  
  
### limit output records
```
db.collectionname.find().limit(10)
```
  
### Looping over records.
JS code can be ran on every document
```
db.collectionname.find().forEach(
    function(doc){
        print('Title' + doc.titleField)
    }
)
```
  
### Aggregation
#### Counting Output records
```
db.collectionname.find({ field : value }).count()
```
  
### Update document
#### Replace whole document
Here first parameter is filter condition, 2nd parameter is whole doc which will be replaced and 3rd parameter is optional 
```
db.collectionname.update({
     field : 'filter value'
}, {
    field1: 'new string value',
    field2: newnumber,
    filed3: [new list of values],
}, {
    upsert: true
})
```
  
#### Replace only provided fields in document
Use $set operator for updating only provided fields
```
db.collectionname.update({
     field : 'filter value'
}, {
    $set: {
        field1: 'new string value',
        field2: newnumber,
        filed4: true
    }
})
```
  
#### Incremental update numeric values 
Use $inc operator to increment numeric values while updating
```
db.collectionname.update({
     field : 'filter value'
}, {
    $inc: {
        field2: increment_by_value,
    }
})
```
  
#### Rename a filed
User $rename to rename a field name
```
db.collectionname.update({
     field : 'filter value'
}, {
    $rename: {
        field2: 'newfieldname',
    }
})
```
  
### Drop column
Use $unset operator to drop a column
```
db.collectionname.update({
    {},
    {
        $unset: {"column_to_drop"}
    }
})
```
  
### Deleting a document
```
db.collectionname.remove({
    filterfield : 'filtervalue'
})
```
  
### Create Index
you can create index on text field as follow
```
db.collectionname.createIndex({ fieldname: 'text' })
```
  
### Searching / Filter on Index
You can do partial search in indexed fileds using $text and $search operators
```
db.collectionname.find({
    $text: {
        $search: "\" text value to search with escaped double quotes\""
    }
})
```
  
You can also use $gt for greater than, $gte for greater than and equal, $lt for less than and $lte for less than and equals searches
```
db.collectionname.find({
    fieldname : { $gt : somenumber }
})
```
  
# Thanks to courses
[Mongo DB With Python](https://www.youtube.com/watch?v=E-1xI85Zog8)
  
[MongoDb Crash Course](https://www.youtube.com/watch?v=-56x56UppqQ)