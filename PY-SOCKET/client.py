import socket

## Define Port where to run server
PORT = 5050

## Get IP of current Host
HOST = '127.0.1.1'

## Get Server address in Tuple 
ADDR = (HOST, PORT)

## Header size from Client to Server. 
HEADER_SIZE = 64 ## 64 bytes of header

## Data Encoding
DATA_FORMAT = 'utf-8'

## Disconnect Message
DISCONNECT_MSG = '!DISCONNECT'

## Create client object
client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

## Conenct the Client
client.connect(ADDR)

def send_msg(msg):
    ## Encode message to Byte
    message = msg.encode(DATA_FORMAT)

    ## Encode Message length
    msg_len = str(len(message)).encode(DATA_FORMAT)

    ## Padd Bytes to make it size of header
    send_len = msg_len + b' ' * (HEADER_SIZE - len(msg_len))

    ## Send Message Length
    client.send(send_len)

    ## Send Message
    client.send(message)

    ## Get acknowledgement
    ## 2048 is arbitrary number for getting fixed length from server
    print(f'[SERVER MESSAGE]: {client.recv(2048).decode(DATA_FORMAT)}') 


if __name__ == '__main__':
    send_msg('Hello, World !!!')
    send_msg(DISCONNECT_MSG)