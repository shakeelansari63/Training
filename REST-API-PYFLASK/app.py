from flask import Flask
from flask_restful import Api, Resource, abort
from flask_restful.reqparse import RequestParser

# Make an App
app = Flask(__name__)
# Make and Api
api = Api(app)

# Create a Demo resource
class Demo(Resource):
    # Override access methods
    def get(self):
        return {"data": "Hello World"}
    
    def post(self):
        return {"posted": True}

# Create Resource with Parameterised input
class ParmInp(Resource):
    data = {
        "tina": {"age": 30, "gender": "f"},
        "anil": {"age": 50, "gender": "m"}
    }
    # Get Method
    def get(self, name):
        return self.data[name]

# Some serious class with Data manipulation
class Video(Resource):
    videos = {} # Empty Data, will be filled with put method

    # Request parser to make sure data ahev required inputs
    video_parser = RequestParser()
    video_parser.add_argument("name", type=str, help="Name missing", required=True)
    video_parser.add_argument("views", type=int, help="Views missing", required=True)
    video_parser.add_argument("likes", type=int, help="Likes missing", required=True)

    # Get video by Id
    def get(self, video_id):
        if video_id not in self.videos:
            # send abort message if video does not exist
            abort(404, message="Video does not exist")
            
        return self.videos[video_id]

    # Save video with put method
    def put(self, video_id):
        # Parse Arguments data sent with Request
        args = self.video_parser.parse_args()

        # Add video in Data
        self.videos[video_id] = args

        return self.videos[video_id], 201 # 201 is return code

# Register a Resource in app
api.add_resource(Demo, "/demo") # First is class and second is url
# Register Parameterised Resource
api.add_resource(ParmInp, "/parminp/<string:name>")

# Register Video Resource
api.add_resource(Video, "/video/<int:video_id>")

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=8081, debug=True)