import json
from confluent_kafka import Consumer

# Create Consumer Instance
consumer = Consumer({
    "bootstrap.servers": "localhost:9092", 
    "auto.offset.reset": "earliest",
    "group.id": "order-tracker2"
})

# Lets Subscribe the consumer to a topic
consumer.subscribe(["orders"])

# We need to run following in Try Except block, as it will be running indefinitely.
# And we don't want any error if it end user stop the consumer manually
try:
    while True:
        msg = consumer.poll(1.0)

        # If there is no message, we will continue
        if msg is None:
            continue

        # If there is any error, we will display error to user and continue to wait for message
        if msg.error():
            print(f"Error occured: {msg.error()}")
            continue

        # If there is valid message, parse it and lets print it
        value = msg.value().decode("utf-8")
        order = json.loads(value)

        # Display order info
        print(f"Received order: {order['quantity']} x {order['item']} from {order['user']}")

# Catch Keyboard interupt from user and gracefully close app
except KeyboardInterrupt:
    print("Consumer connection closed")

# It is important to gracefully close consumer connection for releasing the server resources
finally:
    consumer.close()