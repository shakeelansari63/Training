import socket
import threading

## Define Port where to run server
PORT = 5050

## Get IP of current Host
HOST = socket.gethostbyname(socket.gethostname())

## Get Server address in Tuple 
ADDR = (HOST, PORT)

## Header size from Client to Server. 
HEADER_SIZE = 64 ## 64 bytes of header

## Data Encoding
DATA_FORMAT = 'utf-8'

## Disconnect Message
DISCONNECT_MSG = '!DISCONNECT'

## Create server
## AF_INET is family of socket and SOCK_STREM is type
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

## Bind the server to Address
server.bind(ADDR)


## Function for handling Client
def handle_client(conn, addr):
    ## Print client address for knowing who connected
    print(f'[NEW CONNECTION] : {addr} connected.')

    ## While Connected to client, transmit messages
    connected = True
    while connected:
        ## Recieve header from client which tell the actual length of message
        msg_len = conn.recv(HEADER_SIZE).decode(DATA_FORMAT)

        ## Check for empty message
        if msg_len:
            ## Header had length of actual message, so now recieve the message
            msg = conn.recv(int(msg_len)).decode(DATA_FORMAT)

            ## Diplay message from server
            print(f'[ {HOST}:{PORT} ] : {msg}')

            if msg == DISCONNECT_MSG:
                connected = False
            else:
                ## Acknowledge message reception
                conn.send('Message Recieved !!!'.encode(DATA_FORMAT))
    
    ## Close connection on disconnection
    conn.close()


## Function for starting server
def start():
    ## Listening on provided port for client connections
    server.listen()
    print('[STARTED]: Server Started. ')
    print(f'[LISTENING]: Server listening at {HOST}:{PORT}')
    ## Infinite loop for listening and accepting client requests
    while True:
        conn, addr = server.accept()

        ## Create new thread for handling client
        thread = threading.Thread(target = handle_client, args = (conn, addr))
        thread.start()


## Function to Close server
def stop():
    
    print('[STOPPING]: Stopping server...')

    ## Stop Server
    server.close()

    print('[STOPPED]: Server Stopped.')


if __name__ == '__main__':
    print('[STARTING]: Starting Server...')

    ## Start Server
    try:
        start()
    except KeyboardInterrupt:
        stop()