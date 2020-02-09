import mongoengine

def global_mongo_setup():
    """This function should be called only one for connecting MongoDB"""
    connection_var = dict(
        username = 'root', 
        password = 'root', 
        alias = "mongo", 
        name = "freak_mongo", 
        host = "0.0.0.0", 
        port = 27017, 
        authentication_source = 'admin'
    )
    mongoengine.register_connection(**connection_var)