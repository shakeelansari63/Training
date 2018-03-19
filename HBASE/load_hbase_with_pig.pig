REGISTER '/usr/hdp/current/pig-client/piggybank.jar'

usersData = LOAD '/data/users.dat' 
USING org.apache.pig.piggybank.storage.MyRegExLoader('(\\w+)::(\\w+)::(\\w+)::(\\w+)::(\\w+)')
AS (userID:chararray, gender:chararray, age:chararray, occupation:chararray, zip:chararray);

users = FILTER usersData by gender != 'Gender';

STORE users INTO 'hbase://user' 
USING org.apache.pig.backend.hadoop.hbase.HBaseStorage (
'userinfo:age,userinfo:gender,userinfo:occupation,userinfo:zip');
