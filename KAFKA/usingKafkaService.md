# List Existing Topics
  ```console
  /usr/hdp/current/kafka-broker/kafka-topics.sh --list --zookeper sandbox-hdp.hortonworks.com:2181
  ```

# Create New Topic
  ```console
  /usr/hdp/current/kafka-broker/kafka-topics.sh --create --zookeper sandbox-hdp.hortonworks.com:2181 --replication-factor 1 --partition 1 --topic TopicName
  ```

# Sample producer From console input
  ```console
  /usr/hdp/current/kafka-broker/kafka-console-producer.sh --broker-list sandbox-hdp.hortonworks.com:6667 --topic TopicName
  ```

# Sample consumer on console output
  ```console
  /usr/hdp/current/kafka-broker/kafka-console-consumer.sh --bootstrap-server sandbox-hdp.hortonworks.com:6667 --zookeper sandbox-hdp.hortonworks.com:2181 --topic TopicName --from-beginning
  ```
