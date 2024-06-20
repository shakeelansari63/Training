# Alembic

Alembic is a Database Migration tool for Python + SqlAlchemy

# Initialize Alembic

```bash
alembic init <app name>
```

This will create a directory with `<app name>` which will have all the files and folders required for alembic.

E.g.

```bash
alembic init test-app
```

# Understanding the structure

```
project-root/
 └ alembic.ini # This has Alembic Config file
 └ appname/ # This is base directory for alembic files
     └ env.py # This python scripts runs when alembic is ran
     └ script.py.mako
     └ versions/ # This is where alembic revisions are kept
         └ *.py # Alembic revisions
```
