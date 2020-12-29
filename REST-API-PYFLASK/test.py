import requests

BASE = "http://0.0.0.0:8081/"

DEMO = 'demo'
PARAM = 'parminp/'

demo_response = requests.get(BASE + DEMO)
print(demo_response.json())

demo_response = requests.post(BASE + DEMO)
print(demo_response.json())

parm_response = requests.get(BASE + PARAM + 'tina')
print(parm_response.json())
