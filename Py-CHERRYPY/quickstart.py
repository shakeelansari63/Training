import cherrypy

class SomeClass():
    @cherrypy.expose
    def index(self):
        return "You are in"

class JsonClass():
    @cherrypy.expose
    @cherrypy.tools.json_out()
    def index(self):
        return {'Hello': 'World'}

if __name__ == '__main__':
    cherrypy.quickstart(JsonClass())
