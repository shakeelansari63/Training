from pyspark import SparkConf, SparkContext

conf = SparkConf().setMaster('local').setAppName('TotalAmountByCustomer')
sc = SparkContext(conf = conf)

def parse_line(txt):
    splited_text = txt.split(',')
    cust_no = int(splited_text[0])
    amount = float(splited_text[2])
    return (cust_no, amount)

lines = sc.textFile('customer-orders.csv')
rdd = lines.map(parse_line)
sum_amount = rdd.reduceByKey(lambda x, y: x + y)

for cust_no, total_amount in sorted(sum_amount.collect(), key = lambda x: x[1]):
    print(f'{cust_no:3} spent {total_amount:.2f}')
