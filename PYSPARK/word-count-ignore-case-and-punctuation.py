from pyspark import SparkConf, SparkContext
import re

def regular_split(text):
    return re.compile(r'\W+', re.UNICODE|re.I).split(text.lower())

conf = SparkConf().setMaster("local").setAppName("WordCount")
sc = SparkContext(conf = conf)

inputs = sc.textFile("Book.txt")
words = inputs.flatMap(regular_split)
wordCounts = words.countByValue()

for word, count in sorted(wordCounts.items(), key = lambda x: x[1], reverse = True)[:100]:
    cleanWord = word.encode('ascii', 'ignore')
    if (cleanWord):
        print(cleanWord.decode() + " " + str(count))
