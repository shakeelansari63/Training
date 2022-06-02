from pyspark.sql import SparkSession, functions as sparkFunc
from pyspark.sql.types import StructType, StructField, IntegerType, FloatType, StringType

schema = StructType([\
                        StructField('customerId', IntegerType()),\
                        StructField('saleId', StringType()),\
                        StructField('expense', FloatType())\
                    ])

with SparkSession.builder.appName('Customer Expenditure').getOrCreate() as spark:
    spark.sparkContext.setLogLevel('WARN')
    
    df = spark.read.schema(schema).csv('customer-orders.csv')
    
    df.groupBy('customerId')\
        .agg(sparkFunc.round(sparkFunc.sum('expense'), 2)\
            .alias('totalExpense'))\
        .orderBy(sparkFunc.col('totalExpense'), ascending=False)\
        .show()