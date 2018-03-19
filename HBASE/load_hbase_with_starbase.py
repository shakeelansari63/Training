#!/usr/bin/python
from starbase import Connection

c = Connection("sandbox-hdp","8000")

ratings = c.table('rating')

if (ratings.exists()):
	print("Dropping Ratings Table")
	ratings.drop()
	
ratings.create('rating')
batch = ratings.batch()

print("Parsing Ratings Data")
ratData = open("/mnt/c/Users/shake/Training/Data/ratings.dat","r")
skipHead = ratData.readline()
del skipHead

print("Loading Ratings Table")
for line in ratData:
	(UserId,MovieId,Rating,Timestamp)=line.split("::")
	batch.update(UserId, {'rating': {MovieId: Rating}})

ratData.close()

print("Commit Ratings Data")

batch.commit(finalize=True)

