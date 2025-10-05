import uuid
import json
from confluent_kafka import Producer

# Create Producer Instance
producer = Producer({"bootstrap.servers": "localhost:9092"})

# Sample Data from Producer
data = {
    "id": str(uuid.uuid4()),
    "user": "Freak",
    "item": "USB C Cable",
    "quantity": "5",
}

# Before Sending data to kafka broker, it need to be converted to bytes
# So the Json needs to be converted to String and then to bytes
data_str = json.dumps(data)
data_bytes = data_str.encode("utf-8")

# We will need a callback function which will be used to handle error
# or display success message on message delivery to broker
def producer_delivery_report(err, msg):
    if err:
        print(f"Error occured: {err}")
        return
    
    # On success, display delivery detail
    print(f"Delivered Message: {msg.value().decode("utf-8")}")
    print(f"  to Topic - {msg.topic()}")
    print(f"  on Partition - {msg.partition()}")
    print(f"  at Offset - {msg.offset()}")


# Send data to Kafka Broker on Orders Topic
producer.produce(topic="orders", value=data_bytes, callback=producer_delivery_report)

# It is good idea to flush the producer. Sometimes Producer buffers the data and tries to push data
# to broker in batch. Flushing will force producer to send all data to Broker
producer.flush()