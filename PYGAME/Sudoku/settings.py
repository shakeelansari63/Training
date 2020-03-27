# Game Statics
GAME_NAME = "Sudoku"

# Game Sizing
BOX_LENGTH = 80
PADD = 20
BUTTON_HEIGHT = 60
BUTTON_WIDTH = 150
GRID_NUM_SIZE = 50

WIDTH = (BOX_LENGTH * 9) + (2 * PADD)
HEIGHT = (BOX_LENGTH * 9) + (3 * PADD) + BUTTON_HEIGHT

GAME_AREA = {"START-X": PADD, "START-Y": PADD, "END-X": WIDTH - PADD, "END-Y":HEIGHT - ( (2 * PADD) + BUTTON_HEIGHT)}

BUTTON_AREA = {"START-X": PADD, "START-Y": GAME_AREA["END-Y"] + PADD, "END-X": WIDTH - PADD, "END-Y": HEIGHT - PADD}

## Grid
test_grid = [ [ 0 for _ in range(9) ] for _ in range(9) ]

test_board_2 = [
    [0, 6, 0, 2, 0, 0, 8, 3, 1],
    [0, 0, 0, 0, 8, 4, 0, 0, 0],
    [0, 0, 7, 6, 0, 3, 0, 4, 9],
    [0, 4, 6, 8, 0, 2, 1, 0, 0],
    [0, 0, 3, 0, 9, 6, 0, 0, 0],
    [1, 2, 0, 7, 0, 5, 0, 0, 6],
    [7, 3, 0, 0, 0, 1, 0, 2, 0],
    [8, 1, 5, 0, 2, 9, 7, 0, 0],
    [0, 0, 0, 0, 7, 0, 0, 1, 5],
]

## Colors Definition
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
PALE_BLUE = (96, 216, 232)
DARK_BLUISH = (102, 102, 153)
LIGHT_BLUISH = (133, 133, 173)
