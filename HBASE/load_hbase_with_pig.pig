REGISTER '/usr/hdp/current/pig-client/piggybank.jar'

usersData = LOAD '/data/users.dat' 
USING org.apache.pig.piggybank.storage.MyRegExLoader('([^\\:]+)::([^\\:]+)::([^\\:]+)::([^\\:]+)::([^\\:]+)')
AS (userID:int, gender:chararray, age:int, occupation:chararray, zip:int);

users = FILTER usersData by $0>1;

STORE users INTO 'hbase://user' 
USING org.apache.pig.backend.hadoop.hbase.HBaseStorage (
'userinfo:age,userinfo:gender,userinfo:occupation,userinfo:zip');
