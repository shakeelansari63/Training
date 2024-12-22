from fastapi import FastAPI

app = FastAPI()


@app.get("/")
def root() -> dict[str, str]:
    return {"Hello": "World"}


@app.get("/about")
def about() -> str:
    return "This is great work"
