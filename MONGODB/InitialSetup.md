# Install the Mongo DB on Hadoop Node.
You can use MongoDB Ambari Stack - [Here](https://github.com/nikunjness/mongo-ambari)
```console
cd /var/lib/ambari-server/resources/stacks/HDP/2.X/services/
git clone https://github.com/nikunjness/mongo-ambari.git
service ambari restart
```

And follow the Ambari UI to install Mondo DB on Cluster

# Install Python Mongo DB connector "pymongo"
```console
pip install pymango
```

And you are ready to use Mongo DB in HDP

# Invoke MongoDB Shell
```console
mongo
```
