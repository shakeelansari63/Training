from pyspark import SparkConf, SparkContext

def formatOrderData(text):
    cust_id, _, amount = text.split(',')
    return (int(cust_id), float(amount))
    
conf = SparkConf().setMaster('local').setAppName('CustomerExpense')
sc = SparkContext(conf = conf)
# read data
line = sc.textFile('customer-orders.csv')

# Split columns
rdd = line.map(formatOrderData).reduceByKey(lambda x, y: x + y)

# Order by Count
sortedData = rdd.map(lambda x: (x[1], x[0])).sortByKey().map(lambda x: (x[1], x[0])).collect()

for uid, amount in sortedData:
    print(uid,amount, sep = "\t\t")
