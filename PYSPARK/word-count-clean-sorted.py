from pyspark import SparkConf, SparkContext
import re

def regular_split(text):
    return re.compile(r'\W+', re.UNICODE|re.I).split(text.lower())

conf = SparkConf().setMaster("local").setAppName("WordCount")
sc = SparkContext(conf = conf)

inputs = sc.textFile("Book.txt")
words = inputs.flatMap(regular_split)
word_counts = words.map(lambda x: (x, 1)).reduceByKey(lambda x, y: x + y)
sorted_counts = word_counts.map(lambda x: (x[1], x[0])).sortByKey(ascending=False)

for count, word in sorted_counts.collect()[:100]:
    cleanWord = word.encode('ascii', 'ignore')
    if (cleanWord):
        print(cleanWord.decode() + " " + str(count))
