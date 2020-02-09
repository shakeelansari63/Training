import mongoengine

# New user class which extend MongoEngine Document class
class User(mongoengine.Document):
    user_name = mongoengine.StringField(required = True)
    age = mongoengine.IntField(required = True, min_value = 5)
    is_male = mongoengine.BooleanField(required = True, default = True)

    # required metadata for mongo Engine
    meta = {
        'db_alias' : 'mongo',
        'collection' : 'users'
    }
