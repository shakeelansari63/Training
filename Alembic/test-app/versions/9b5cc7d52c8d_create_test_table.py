"""Create test table

Revision ID: 9b5cc7d52c8d
Revises:
Create Date: 2024-06-20 20:24:44.644709

"""

from typing import Sequence, Union

from alembic import op
import sqlalchemy as sa


# revision identifiers, used by Alembic.
revision: str = "9b5cc7d52c8d"
down_revision: Union[str, None] = None
branch_labels: Union[str, Sequence[str], None] = None
depends_on: Union[str, Sequence[str], None] = None


def upgrade() -> None:
    op.create_table(
        "employee",
        sa.Column("id", sa.Integer, primary_key=True),
        sa.Column("name", sa.String, nullable=False),
        sa.Column("is_active", sa.Boolean, default=False),
    )


def downgrade() -> None:
    op.drop_table("employee")
