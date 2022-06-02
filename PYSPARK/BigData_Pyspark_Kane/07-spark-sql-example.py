from pyspark.sql import SparkSession, Row

def friendsMapper(line):
    id, name, age, friends = line.split(',')
    return Row(id=int(id), name=str(name), age=float(age), friends=int(friends))

with SparkSession.builder.appName('Spark Dataframe Example').getOrCreate() as spark:
    # Hide log Infos
    spark.sparkContext.setLogLevel('WARN')
    
    # Create RDD
    friends_rdd = spark.sparkContext.textFile('fakefriends.csv').map(friendsMapper)
    # Convert RDD to DF
    friends_df = spark.createDataFrame(friends_rdd).cache()
    
    # Create in memory SQL table
    friends_df.createOrReplaceTempView("friends")
    
    # Query on in memory table
    teens = spark.sql("select * from friends where age >= 13 and age <= 19")
    teens.show()
    
    # Query in DF directly programatically
    friends_df.groupBy("age").count().orderBy("age").show()