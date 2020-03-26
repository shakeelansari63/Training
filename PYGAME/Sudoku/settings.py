# Game Statics
GAME_NAME = "Sudoku"

# Game Sizing
BOX_LENGTH = 80
PADD = 20
BUTTON_AREA = 80

WIDTH = (BOX_LENGTH * 9) + (2 * PADD)
HEIGHT = (BOX_LENGTH * 9) + (2 * PADD) + BUTTON_AREA

GAME_AREA = {"START-X": PADD, "START-Y": PADD, "END-X": WIDTH - PADD, "END-Y":HEIGHT - (PADD + BUTTON_AREA)}

## Grid
test_grid = [ [ 0 for _ in range(9) ] for _ in range(9) ]

## Colors Definition
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
PALE_BLUE = (96, 216, 232)
