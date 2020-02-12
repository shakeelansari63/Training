from data import global_mongo_setup
from service import create_user, get_all_users, get_user_by_name
from service import get_user_by_name_pattern

if __name__ == '__main__':
    # Setup MongoDB Connection
    global_mongo_setup()

    # Run Loop
    while True:
        print("""-- Select Option --
[A]dd User
[L]ist all Users
[F]ind User
e[X]it
""")
        user_option = input("Select Choice: ").lower().strip()
        if user_option == "x":
            print("Bye !!!")
            break

        elif user_option == "a":
            name = input("Enter Name: ")
            age = int(input("Enter Age: "))
            gender = input("Enter Gender (M/F): ")
            petnames = input("List names of pets seperated by ',': ")\
                .strip().split(',')
            pet_names = list(map(str.strip, petnames))
            male = True if gender in ('M', 'm') else False
            uid = create_user(name, age, male, pet_names)

            # Check if user is created
            if uid is not None:
                print(f"User Created with id - {uid}")
            else:
                print("User Name already exist")

        elif user_option == "l":
            u = get_all_users()
            for usr in u:
                print(usr)

        elif user_option == "f":
            print("""
    -- Select Search Criteria --
    Full [N]ame
    Partial Na[M]e
    Exact [A]ge
    Age [R]ange""")
            search_criteria = input("Choice: ").lower().strip()
            if search_criteria == 'n':
                inp_name = input("Enter name to search: ").strip()
                u = get_user_by_name(inp_name)
                if u:
                    print(u)
                else:
                    print("User not found")

            elif search_criteria == 'm':
                inp_name = input("Enter name Pattern to search: ").strip()
                u = get_user_by_name_pattern(inp_name)
                if u:
                    for usr in u:
                        print(u)
                else:
                    print("User not found")

            elif search_criteria == 'a':
                print("Under Costruction")

            elif search_criteria == 'r':
                print("Under Costruction")

        else:
            print("Incorrect Option")
