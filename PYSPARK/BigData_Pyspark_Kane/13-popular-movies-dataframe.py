from pyspark.sql import SparkSession
from pyspark.sql import functions as func
from pyspark.sql.types import StructType, StructField, IntegerType, LongType

# Create schema when reading u.data
schema = StructType([ \
                     StructField("userID", IntegerType(), True), \
                     StructField("movieID", IntegerType(), True), \
                     StructField("rating", IntegerType(), True), \
                     StructField("timestamp", LongType(), True)])

with SparkSession.builder.appName("PopularMovies").getOrCreate() as spark:
    # Set Logging
    spark.sparkContext.setLogLevel('WARN')
    # Load up movie data as dataframe
    moviesDF = spark.read.option("sep", "\t").schema(schema).csv("ml-100k/u.data")

    # Some SQL-style magic to sort all movies by popularity in one line!
    topMovieIDs = moviesDF.groupBy("movieID").count().orderBy(func.desc("count"))

    # Grab the top 10
    topMovieIDs.show(10)
