import flet as ft

def main(page: ft.Page):
    # Define Text
    hello = ft.Text(value="Hello World!!", color="green")

    # Add text to Page
    page.controls.append(hello)

    # Update Page
    page.update()

ft.app(target=main)