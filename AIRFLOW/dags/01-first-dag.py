from datetime import datetime, timedelta
from airflow import DAG
from airflow.operators.bash import BashOperator

dag_defaults = {
    "owner": "ShakeelAnsari",
    "retries": 5,
    "retry_delay": timedelta(minutes = 1)
}

with DAG(
    dag_id="first-dag",
    description="My First Dag",
    default_args=dag_defaults,
    start_date=datetime(2023, 1, 13, 19),
    schedule_interval="@daily"
) as dag:
    t1 = BashOperator(
        task_id='execute-hello',
        bash_command="echo Hello World!!"
    )

    t1