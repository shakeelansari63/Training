from pyspark.sql import SparkSession, functions as sparkFunc
from pyspark.sql.types import StructType, StructField, IntegerType, StringType, FloatType

data_schema = StructType([\
                          StructField('StationId', StringType()),\
                          StructField('Date', StringType()),\
                          StructField('TemperatureType', StringType()),\
                          StructField('Temperature', IntegerType())
                         ])

with SparkSession.builder.appName('Min Temp').getOrCreate() as spark:
    spark.sparkContext.setLogLevel('WARN')
    
    df = spark.read.schema(data_schema).csv('1800.csv')
    
    # Display Min Temperature
    df.filter(df.TemperatureType == 'TMIN')\
        .groupBy('StationId')\
        .agg(sparkFunc.min('Temperature').alias('MinTemperature'))\
        .select('StationId', 
                sparkFunc.round(sparkFunc.col('MinTemperature') * 0.1, 2).alias('MinTemperatureInCelcius'), 
                sparkFunc.round(sparkFunc.col('MinTemperature') * 0.1 * (9/5) + 32, 2).alias('MinTemperatureInFahrenheit'))\
        .show()