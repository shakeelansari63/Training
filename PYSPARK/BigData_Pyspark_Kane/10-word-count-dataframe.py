from pyspark.sql import SparkSession, functions as sparkFunc

with SparkSession.builder.appName('Word Count').getOrCreate() as spark:
    spark.sparkContext.setLogLevel('WARN')
    
    df = spark.read.text('Book.txt')
    
    df.select(sparkFunc.explode(sparkFunc.split(df.value, '\\W+'))\
              .alias('word'))\
        .filter(sparkFunc.col('word') != '')\
        .groupBy('word')\
        .agg(sparkFunc.count('word')\
            .alias('occurance'))\
        .orderBy('occurance', ascending=False)\
        .show()