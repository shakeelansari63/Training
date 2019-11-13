from pyspark import SparkConf, SparkContext

def loadMovieNames():
    movieNames = {}
    with open("/home/freak/Project/datasets/ml-10M/movies.dat") as f:
        for line in f:
            fields = line.split('::')
            movieNames[int(fields[0])] = fields[1]
    return movieNames

conf = SparkConf().setMaster("local").setAppName("PopularMovies")
sc = SparkContext(conf = conf)

nameDict = sc.broadcast(loadMovieNames())

lines = sc.textFile("/home/freak/Project/datasets/ml-10M/ratings.dat")
movies = lines.map(lambda x: (int(x.split('::')[1]), 1))
movieCounts = movies.reduceByKey(lambda x, y: x + y)

flipped = movieCounts.map( lambda x : (x[1], x[0]))
sortedMovies = flipped.sortByKey()

sortedMoviesWithNames = sortedMovies.map(lambda countMovie : (nameDict.value[countMovie[1]], countMovie[0]))

results = sortedMoviesWithNames.collect()

for result in results:
    print (f'{result[0]:50} has been watched {result[1]} times')
