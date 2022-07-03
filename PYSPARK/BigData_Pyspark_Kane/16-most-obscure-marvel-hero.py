from pyspark.sql import SparkSession, functions as func
from pyspark.sql.types import StructType, StructField, IntegerType, StringType

with SparkSession.builder.appName("Most Popular Hero").getOrCreate() as spark:
    spark.sparkContext.setLogLevel("WARN")
    
    name_schema = StructType([
                    StructField("id", IntegerType(), True),
                    StructField("name", StringType(), True),])
    
    names_df = spark.read.schema(name_schema).option("sep", " ").csv('marvel-names.txt')
    
    lines_df = spark.read.text('marvel-graph.txt')
    
    connections = lines_df.withColumn("id", func.split(func.col("value"), ' ')[0])\
        .withColumn("conn", func.size(func.split(func.col("value"), ' ')) - 1)\
        .groupBy("id")\
        .agg(func.sum(func.col("conn")).alias("no_conns"))\
        .orderBy("no_conns")
    
    obscure_hero_friends = connections.first()["no_conns"]
    
    obscure_heros = connections.filter(func.col("no_conns") == obscure_hero_friends)\
        .join(names_df, "id")\
        .select("id", "name")
    
    obscure_heros.show()