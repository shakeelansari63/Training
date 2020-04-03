# CherryPy Quickstart
## Import CherryPy
```python
import cherrypy
```
  
## Create Class
### Every Route in CherryPy is a Class and expose tells that following method will be accessed by browser
### Index function is mandatory and needed in cherrypy
```python
class Foo():
    @cherrypy.expose
    def index(self):
        return 'Hello World'
```
  
## Start CheeryPy WebServer
```python
cherrypy.quickstart(Foo())
```
  
## CherryPy can return Json as output with just 1 json decorator
### The docorator will Add Json headers in response for APIs
```python
class Foo():
    @cherrypy.expose
    @cherrypy.tools.json_out()
    def index(self):
        return {'Hello': 'World'}