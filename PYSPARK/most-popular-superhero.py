from pyspark import SparkConf, SparkContext

conf = SparkConf().setMaster("local").setAppName("PopularHero")
sc = SparkContext(conf = conf)

def countCoOccurences(line):
    elements = line.split()
    return (int(elements[0]), len(elements) - 1)

def parseNames(line):
    fields = line.split('\"')
    return (int(fields[0]), fields[1].encode("utf8"))

names = sc.textFile("Marvel-Names.txt")
namesRdd = names.map(parseNames)

lines = sc.textFile("Marvel-Graph.txt")

pairings = lines.map(countCoOccurences)
totalFriendsByCharacter = pairings.reduceByKey(lambda x, y : x + y)

mostPopular = totalFriendsByCharacter.max(key = lambda x: x[1])

mostPopularName = namesRdd.lookup(mostPopular[0])[0]

print(str(mostPopularName) + " is the most popular superhero, with " + \
    str(mostPopular[1]) + " co-appearances.")
