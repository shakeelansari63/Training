import flet as ft
from flet import TextField
from flet import ControlEvent


def main(page: ft.Page) -> None:
    # App Config
    page.title = "Flet Counter App"
    page.vertical_alignment = ft.MainAxisAlignment.CENTER
    page.theme_mode = ft.ThemeMode.LIGHT

    # Create Text Field
    text_num: TextField = TextField(value="0", text_align=ft.TextAlign.CENTER, width=80)

    # Actions
    def increment(ev: ControlEvent) -> None:
        text_num.value = str(int(text_num.value if text_num.value else "0") + 1)
        page.update()

    def decrement(ev: ControlEvent) -> None:
        text_num.value = str(int(text_num.value if text_num.value else "0") - 1)
        page.update()

    # Add Objects to Page
    page.add(
        ft.Row(
            controls=[
                ft.IconButton(ft.icons.REMOVE, on_click=decrement),
                text_num,
                ft.IconButton(ft.icons.ADD, on_click=increment),
            ],
            alignment=ft.MainAxisAlignment.CENTER,
        )
    )


# Run the App
if __name__ == "__main__":
    ft.app(target=main)
