from .base import BaseModel, Metadata
import sqlalchemy as sa

metadata = Metadata


class Company(BaseModel):
    __tablename__ = "company"

    id = sa.Column(sa.Integer, primary_key=True)
    name = sa.Column(sa.String(64), unique=True)
    created = sa.Column(sa.DateTime, default=sa.func.now())
