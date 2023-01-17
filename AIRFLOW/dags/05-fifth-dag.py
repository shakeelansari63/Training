from airflow.decorators import dag, task
from datetime import datetime, timedelta

dag_defaults = {
    "owner": "Shakeel Ansari",
    "retries": 2,
    "retry_delay": timedelta(seconds = 10),
    "start_date": datetime(2023, 1, 15, 12)
}

# Python Dags with task flow
@dag(dag_id="fifth-dag", description="Third DAG", default_args=dag_defaults, schedule_interval="@daily")
def fifth_dag():
    # Task is also a method
    @task
    def get_age():
        return 20

    # Multiple Outputs needed to tell next operator that output is dictionaary and not string
    @task(multiple_outputs = True)
    def get_name():
        return {
            "firstname": "Jose",
            "lastname": "Fridman"
        }

    @task
    def greet(firstname, lastname, age):
        print(f"Hello I am {firstname} {lastname} and I am {age} years old")

    name = get_name()
    age = get_age()
    greet(name['firstname'], name['lastname'], age)

fifth_dag()
