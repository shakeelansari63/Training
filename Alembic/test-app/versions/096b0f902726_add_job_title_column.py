"""Add Job Title Column

Revision ID: 096b0f902726
Revises: 9b5cc7d52c8d
Create Date: 2024-06-20 20:50:50.842754

"""

from typing import Sequence, Union

from alembic import op
import sqlalchemy as sa


# revision identifiers, used by Alembic.
revision: str = "096b0f902726"
down_revision: Union[str, None] = "9b5cc7d52c8d"
branch_labels: Union[str, Sequence[str], None] = None
depends_on: Union[str, Sequence[str], None] = None


def upgrade() -> None:
    op.add_column("employee", sa.Column("job_title", sa.String(64)))


def downgrade() -> None:
    op.drop_column("employee", "job_title")
