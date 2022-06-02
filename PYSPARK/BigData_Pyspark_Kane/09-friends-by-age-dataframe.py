from pyspark.sql import SparkSession
from pyspark.sql import functions as sparkFunc

with SparkSession.builder.appName('Friends By Age').getOrCreate() as spark:
    spark.sparkContext.setLogLevel('WARN')
    
    df = spark.read.option('header', True).option('inferSchema', True).csv('fakefriends-header.csv')
    
    # Option 1
    df.groupBy('age')\
        .avg('friends')\
        .withColumnRenamed('avg(friends)', 'avgFriends')\
        .orderBy('avgFriends', ascending=False)\
        .show()
    
    # Option 2
    df.groupBy('age')\
        .agg(sparkFunc.round(sparkFunc.avg('friends'), 2)\
            .alias('avgFriends'))\
        .sort('avgFriends', ascending=False)\
        .show()