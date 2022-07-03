from pyspark.sql import SparkSession, functions as func
from pyspark.sql.types import StructType, StructField, IntegerType, LongType
import codecs

# Define Schema
schema = StructType([\
                    StructField("userID", IntegerType(), True), 
                    StructField("movieID", IntegerType(), True), 
                    StructField("rating", IntegerType(), True), 
                    StructField("timestamp", LongType(), True)])

def load_movie_names():
    movie_names = {}
    with codecs.open("ml-100k/u.item", 'r', encoding="ISO-8859-1", errors="ignore") as fp:
        for line in fp.readlines():
            field = line.split('|')
            movie_names[int(field[0])] = field[1]
    
    return movie_names

with SparkSession.builder.appName('Popular Movies With Names').getOrCreate() as spark:
    # Set log level
    spark.sparkContext.setLogLevel('WARN')
    
    # broadcast movie names to all executors
    nameDict = spark.sparkContext.broadcast(load_movie_names())
    
    # UDF for Converting Name Dict
    lookupName = func.udf(lambda movieId: nameDict.value[movieId])
    
    df = spark.read.option('sep','\t').schema(schema).csv("ml-100k/u.data")
    
    movieCounts = df.groupBy("movieID").count().orderBy(func.desc("count"))
    
    movieCountWithNames = movieCounts.withColumn("movieTitle", lookupName(func.col("movieID")))
    
    movieCountWithNames.show(10)