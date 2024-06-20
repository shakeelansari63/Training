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

# Configuration

Update the SQLAlchemy URL for database in `alembic.ini` file. This will be used by alembic to connect to Database.

```toml
sqlalchemy.url = driver://user:pass@localhost:port/dbname
```

For Example, to use postgres, we can set it as

```toml
sqlalchemy.url = postgresql://postgres:password@localhost:5432/alembic_test
```

# Creating Revisions Manually

We can manually create alembic revisions by running

```bash
alembic revision -m "Some message"
```

And this will create a new revision python file in versions directory.
The Newly created alembic revision will look like this.

```python
"""Create test table

Revision ID: 9b5cc7d52c8d
Revises:
Create Date: 2024-06-20 20:24:44.644709

"""
from typing import Sequence, Union

from alembic import op
import sqlalchemy as sa


# revision identifiers, used by Alembic.
revision: str = '9b5cc7d52c8d'
down_revision: Union[str, None] = None
branch_labels: Union[str, Sequence[str], None] = None
depends_on: Union[str, Sequence[str], None] = None

# This is upgrade function is called when Alembic applies this migration
def upgrade() -> None:
    pass

# This is upgrade function is called when Alembic removes this migration
def downgrade() -> None:
    pass
```

Now we can write some code un upgrade and downgrade methods.

Example -

```python
# This will create a new table
def upgrade() -> None:
    op.create_table(
        "employee",
        sa.Column("id", sa.Integer, primary_key=True),
        sa.Column("name", sa.String, nullable=False),
        sa.Column("is_active", sa.Boolean, default=False),
    )

# This will drop the table
def downgrade() -> None:
    op.drop_table("employee")
```

# Run Alembic Migration

To run alembic migrations, simply run

```bash
alembic upgrade <revision id>
```

Alembic upgrade need a revision id to upgrade till. But if you just want to upgrade till latest revision, then use `head` as revision id.

Example -

```bash
alembic upgrade head
```

If you login to database now and check, then you will see 2 tables.
| Table name | Comment |
| - | - |
| alembic_version | This table is used by alembic for tracking current revision |
| employee | This is the table we created

# Downgrade to Alembic Migration

If you find any issue and you want to revert the alembic migration, use

```bash
alembic downgrade <revision>
```

Revision id is needed for telling alembic to go to which revision.  
But it also support relative downgrade.

Meaning we can write as follow

```bash
alembic downgrade -1
```

and it will downgarde 1 revision from current

```
Note: Just the way alembic downgrade support -x to go down x revisions, alembic upgrade also supports +x to go above x revisions from current revision.
```

And like `head` we have another revision for downgrade `base` for removing all migrations.

So following will remove all migrations

```bash
alembic downgrade base
```

If you run this, you will see the `employee` table has been dropped. And now there is only `alembic_version` table which is empty.

# Automatic Migrations based on SQLAlchemy Models
