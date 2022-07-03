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
        .orderBy(func.desc("no_conns"))
    
    top_hero = connections.first()
    
    top_hero_name = names_df.filter(func.col("id") == top_hero["id"]).first()["name"]
    
    print(f'{top_hero_name} is top hero with {top_hero["no_conns"]} connections !!!')