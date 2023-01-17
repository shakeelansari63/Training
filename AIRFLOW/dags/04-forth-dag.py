from airflow import DAG
from datetime import datetime, timedelta
from airflow.operators.python import PythonOperator

dag_defaults = {
    "owner": "Shakeel Ansari",
    "retries": 2,
    "retry_delay": timedelta(seconds = 10),
    "start_date": datetime(2023, 1, 15, 12)
}

def task_1(ti):
    ## Push Value to xcom
    ti.xcom_push(key = "firstname", value = "Henry")
    ti.xcom_push(key = "lastname", value = "Ford")

def task_2(ti):
    ## Pull Xcom Values
    fname = ti.xcom_pull(task_ids="first-task", key="firstname")
    lname = ti.xcom_pull(task_ids="first-task", key="lastname")

    print(f"Hello my name is {fname} {lname}")

with DAG(dag_id="forth_dag", description="Third DAG", default_args=dag_defaults, schedule_interval="@daily") as dag:
    task1 = PythonOperator(
        task_id = "first-task",
        python_callable=task_1
    )

    task2 = PythonOperator(
        task_id = "second-task",
        python_callable=task_2
    )

    task1 >> task2