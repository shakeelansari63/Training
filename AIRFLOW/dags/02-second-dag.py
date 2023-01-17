from airflow import DAG
from airflow.operators.bash import BashOperator
from datetime import datetime, timedelta

default_args = {
    "owner": "ShakeelAnsari",
    "retries": 2,
    "retry_delay": timedelta(minutes=1),
    "description": "My Second Dag",
    "start_date": datetime(2023, 1, 14, 19)
}

with DAG(dag_id="second-dag", default_args=default_args, schedule_interval="@daily") as dag:
    task1 = BashOperator(
        task_id = 'first-task',
        bash_command = 'echo First Task'
    )

    task2 = BashOperator(
        task_id = 'second-task',
        bash_command = 'echo Second Task'
    )

    task3 = BashOperator(
        task_id = 'third-task',
        bash_command = 'echo Third Task'
    )

    ## Set Dependency 
    ### Using methods
    # task1.set_downstream(task2)
    # task1.set_downstream(task3)

    ### Using Bitwise operator
    # task1 >> task2
    # task1 >> task3

    ### Using list and bitwise
    task1 >> [task2, task3]