from data import global_mongo_setup
from service import create_user, get_all_users

if __name__ == '__main__':

    name = input("Enter Name: ")
    age = int(input("Enter Age: "))
    gender = input("Enter Gender (M/F): ")
    male = True if gender in ('M', 'm') else False
    global_mongo_setup()
    uid = create_user(name, age, male)

    # Check if user is created
    if uid is not None:
        print(f"User Created with id - {uid}")
    else:
        print("User Name already exist")
    u = get_all_users()
    for usr in u:
        print(usr)
