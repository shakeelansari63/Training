from pyspark import SparkConf, SparkContext

conf = SparkConf().setMaster("local").setAppName("WordCount")
sc = SparkContext(conf = conf)

inputs = sc.textFile("Book.txt")
words = inputs.flatMap(lambda x: x.split())
wordCounts = words.countByValue()

for word, count in sorted(wordCounts.items(), key = lambda x: x[1], reverse = True)[:10]:
    cleanWord = word.encode('ascii', 'ignore')
    if (cleanWord):
        print(cleanWord.decode() + " " + str(count))
