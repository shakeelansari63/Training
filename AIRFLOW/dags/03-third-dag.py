from airflow import DAG
from datetime import datetime, timedelta
from airflow.operators.python import PythonOperator

dag_defaults = {
    "owner": "Shakeel Ansari",
    "retries": 2,
    "retry_delay": timedelta(seconds = 10),
    "start_date": datetime(2023, 1, 16, 12)
}

def task_1():
    print("This is task 1")

def task_2(message):
    print(message)

with DAG(dag_id="third_dag", description="Third DAG", default_args=dag_defaults, schedule_interval="@daily") as dag:
    task1 = PythonOperator(
        task_id = "first-task",
        python_callable=task_1
    )

    task2 = PythonOperator(
        task_id = "second-task",
        python_callable=task_2,
        op_kwargs={"message": "This is second Task"}
    )

    task1 >> task2