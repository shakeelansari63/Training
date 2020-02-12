import mongoengine


# New user class which extend MongoEngine Document class
class User(mongoengine.Document):
    user_name = mongoengine.StringField(required=True)
    age = mongoengine.IntField(required=True, min_value=5)
    is_male = mongoengine.BooleanField(required=True, default=True)
    pet_names = mongoengine.ListField(required=False)

    # required metadata for mongo Engine
    meta = {
        'db_alias': 'mongo',
        'collection': 'users'
    }

    def __str__(self):
        stnr = f'''{{
  name : {self.user_name}
, age : {self.age}
, is_male : {self.is_male}
, pet_name : [ { ", ".join(self.pet_names) } ]
}}'''
        return stnr
