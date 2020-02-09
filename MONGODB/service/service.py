from data import User


def create_user(name, age, is_male):
    # Check if user already exist
    exist_user = get_user_by_name(name)
    if exist_user:
        return None
    else:
        u = User()
        u.user_name = name
        u.age = age
        u.is_male = is_male
        u.save()
        return u.id


def get_all_users():
    u = User.objects()
    return u


def get_user_by_name(name):
    u = User.objects().filter(user_name=name).first()
    return u
