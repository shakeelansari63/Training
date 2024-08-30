from airflow import DAG
from airflow.operators.python_operator import PythonOperator
from datetime import timedelta, datetime
import logging
import sys
import time

def get_logger(logger_name = None):
    formatter = logging.Formatter("%(asctime)s %(name)s %(levelname)s %(funcname)s:%(lineno)d %(message)s")
    logger = logging.getLogger(logger_name) if logger_name else logging.getLogger()
    logger.setLevel(logging.DEBUG)
    console_handler = logging.StreamHandler(sys.stdout)
    console_handler.setFormatter(formatter)
    logger.addHandler(console_handler)
    return logger

class MainClass:
    def __init__(self, args):
        logger_name = None
        for key, val in args.items():
            setattr(self, key, val)
        self.logger = get_logger(logger_name)

    def some_class_method(self):
        self.logger.info("Start testing dummy class ...")
        time.sleep(100)
        self.logger.info("End testing dummy class ...")

dag_args = {'retries': 0}

dag = DAG(
    'cause_daemon_failure',
    default_args = dag_args,
    description = 'Fail dag',
    schedule_interval = None,
    start_date = datetime.now(),
    tags = ['Daemon tester']
)

dag.catchup = False

def my_test_fnc(**kwargs):
    print('Running test function')
    print(kwargs)
    main_obj = MainClass(args=kwargs)
    main_obj.some_class_method()

test_my_fnc = PythonOperator(
    task_id = 'test_my_fnc',
    dag = dag,
    python_callable = my_test_fnc,
    op_kwargs = {
        'my_var_1': 'Hello',
        'send_mail': 1
    }
)

test_my_fnc
