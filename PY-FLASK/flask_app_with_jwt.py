from flask import Flask, jsonify, make_response, request, redirect, make_response
import jwt
import datetime as dt
from functools import wraps

# Make an App
app = Flask(__name__)
app.config['secret'] = 'MySecretKeyForApp'

# Instead of checking for token in each api request, it is better to make a decorator which checks tokes
# and use that decorator for all method where token is needed


def token_required(f):
    # This decorator wraps the sent function
    @wraps(f)
    def pre_processor(*args, **kwargs):
        # Check if token Exist
        token = request.args.get('token')

        if not token:
            return jsonify({'message': 'Token missing!!'}), 401

        # We try to parse token and if token is invalid or expired, it will raise exception
        try:
            jwt.decode(token, app.config['secret'])
        except:
            return jsonify({'message': 'Invalid Token!!'}), 401

        # return the called function
        return f(*args, **kwargs)

    return pre_processor


# API Routes
# Index Page
@app.route('/', methods=['GET', 'POST'])
def index():
    return jsonify({'message': "Hello There!!!"}), 200


# Public Access
@app.route('/public')
def public_page():
    return jsonify({'message': 'You can see this public data!!!'}), 200


# Private access need token and login
@app.route('/private')
@token_required
def private_page():
    return jsonify({'message': 'This is private message for authenticated users'}), 200


# Login to generate JWT
@app.route('/login')
def login():
    # Check if user is authorized / logged on
    auth = request.authorization

    # Function for Authorized users
    # This if for demo, you can authenticate user from DB here
    if auth and auth.password == 'secret':

        # Generate JWT Token which expire after 30 seconds
        token = jwt.encode({'user': auth.username,
                            'exp': dt.datetime.utcnow() + dt.timedelta(seconds=30)}, app.config['secret'])

        # Return Token
        return jsonify({'token': token.decode('UTF8')})

    # Authentication prompt if user not logged in
    return make_response('Could not Authenticate!', 401, {'WWW-Authenticate': 'Basic realm="Login required"'})


if __name__ == "__main__":
    app.run(host='0.0.0.0', port='8080', debug=True)
