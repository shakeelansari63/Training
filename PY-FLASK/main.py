#-- encode: utf8 -- #
## Here we run Flask App on Cherry Py WSGI Server
import logging
from cheroot.wsgi import Server as WSGIServer
from app import app as flask_app

if __name__ == '__main__':
    server = WSGIServer(('0.0.0.0', 8081), flask_app)
    try:
        logging.info('Starting HTTP Server')
        server.start()
    except:
        logging.info('Stopping HTTP Server')
        server.stop()