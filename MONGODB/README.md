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
  
# Thanks to FreeCodeCamp course
[Mongo DB With Python](https://www.youtube.com/watch?v=E-1xI85Zog8&list=WL&index=8&t=206s)
