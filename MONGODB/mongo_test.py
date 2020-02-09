import mongoengine
from data import global_mongo_setup
from data import User

if __name__ == '__main__':
    
    name = "Shakeel"
    age = 30
    male = True
    
    global_mongo_setup()
    u = User()
    u.user_name = name
    u.age = age
    u.is_male = male
    u.save()