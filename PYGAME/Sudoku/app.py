import pygame
import sys
from settings import *
from buttons import *
import requests
from bs4 import BeautifulSoup
import re
import time

# Define app class for Sudoku


class App():
    """App class for Sudoku Game"""

    def __init__(self):
        # Initialize PyGame
        pygame.init()

        # Set Caption and Icon for Game
        pygame.display.set_caption(GAME_NAME)

        # Set Icon
        icon = pygame.image.load('sudoku.png')
        pygame.display.set_icon(icon)

        # Set Running Variable for Pygame Looop
        self.running = True

        # Create PyGame Screen
        self.screen = pygame.display.set_mode((WIDTH, HEIGHT))

        # Set initialization Grid to local Test GRID_NUM_SIZE
        self.init_grid = test_board_2

        # Pull Sudoku from web
        self.get_game_board()

        # Call Reset Function
        self.reset()

    # Define run method

    def run(self):
        while self.running:
            if self.state == "PLAYING":
                self.playing_events()
                self.playing_update()
                self.playing_draw()

        # Close window on Exit
        self.quit()

    # Method to close game
    def quit(self):
        pygame.quit()
        sys.exit()

    # Method to reset Game
    def reset(self):

        # Set Mouse position tracker
        self.mouse_pos = None

        # Selected Cell
        self.selected_cell = None

        # Set Incorrect Cell
        self.incorrect_cell = None

        # Set Current State to Playing
        self.state = "PLAYING"

        # Populate Playing Grid Playing Grid
        self.playing_grid = []
        for row in self.init_grid:
            self.playing_grid.append(row.copy())

        # Define font for Text
        self.font_grid = pygame.font.Font('freesansbold.ttf', GRID_NUM_SIZE)

        # Listing different buttons for different states
        self.play_buttons = []
        self.menu_buttons = []
        self.end_buttons = []

        # Define empty list of locked cells
        self.locked_cells = []

        # List of allowed Number keys
        self.num_keys = [
            pygame.K_1,
            pygame.K_2,
            pygame.K_3,
            pygame.K_4,
            pygame.K_5,
            pygame.K_6,
            pygame.K_7,
            pygame.K_8,
            pygame.K_9
        ]

        # Initialize Cell Change Attribute to check of grid if finished
        self.cell_changed = False

        # Load the Buttons
        self.load()

    # Method to fetch board
    def get_game_board(self):

        # Connect to Server and fetch content
        try:
            sudoku_site = requests.get(WEBSITE)

            # If server is connected correctly then parse content
            if sudoku_site.status_code == 200:

                # Parse content with lxml
                site_data = BeautifulSoup(sudoku_site.text, features='lxml')

                # Extract all Java Scripts
                scripts = "\n".join(str(x) for x in site_data.find_all('script'))

                # Extract Array from Java Script
                unsolved_grid_list = re.compile(RE_FOR_GRID, re.I).findall(scripts)

                # If Array is not found, fall back to test grid
                if len(unsolved_grid_list) == 0:
                    print('Invalid Server Content')

                # If Array is found, Convert it to Python List
                else:
                    unsolved_grid = list(map(int, unsolved_grid_list[0].split(',')))
                    unsolved_board = []

                    # Convert Python 1D 81x1 list to 2D 9x9 grid
                    for i in range(9):
                        unsolved_board.append(unsolved_grid[i * 9:i*9 + 9])

                    # Set Playing Board to this 2D board
                    self.init_grid = tuple(unsolved_board)

            # If server is not conneted, Use Local Test Grid
            else:
                print("Cannot Connect to Server")
        except:
            print("Unable to Connect to Server")

##########################################################################################
##################### Core Playing Methods ###############################################
##########################################################################################

    # Define Events method
    def playing_events(self):
        for event in pygame.event.get():
            # User Pressed Quit Button
            if event.type == pygame.QUIT:
                self.running = False

            # User Clicked
            elif event.type == pygame.MOUSEBUTTONDOWN:
                self.mouse_on_grid()
                self.mouse_on_button()

            # Used Pressed a Key
            elif event.type == pygame.KEYDOWN:

                # IF Number key is pressed on selected cell, then updte cell
                if event.key in self.num_keys and self.selected_cell is not None:
                    self.playing_grid[self.selected_cell[1]
                                      ][self.selected_cell[0]] = int(event.unicode)

                    # Se Cell changed attribute
                    self.cell_changed = True

                # If delete key is pressed on selected cell, then delete cell content
                elif event.key == pygame.K_DELETE and self.selected_cell is not None:
                    self.playing_grid[self.selected_cell[1]][self.selected_cell[0]] = 0

                    # Se Cell changed attribute
                    self.cell_changed = True

    # Define Update method

    def playing_update(self):
        self.mouse_pos = pygame.mouse.get_pos()

        # Update Mouse Position for Playing Buttons
        for button in self.play_buttons:
            button.update(self.mouse_pos)

        # If cell is changed, then check if value is correct
        if self.cell_changed:
            # Check unique values in each row
            if self.check_duplicate_in_rows():
                print('Duplicate Found in Row')

            # Check unique value in each column
            elif self.check_duplicate_in_columns():
                print('Duplicate Found in Column')

            # Check unique value in each small grid
            elif self.check_duplicate_in_grids():
                print('Duplicate Found in Grid')

            elif self.check_all_done():
                print('Grid Complete')

            # If everything is correct, then reset Incorrect Cell
            else:
                self.incorrect_cell = None

    # Defime Draw Method
    def playing_draw(self):

        # Fill White for Background
        self.screen.fill(WHITE)

        # Draw Playing Buttons
        for button in self.play_buttons:
            button.draw(self.screen)

        # Show selected cell
        self.selected_cell_draw()

        # Shade Locked Cells
        self.shade_locked_cells()

        # Shade Incorrect Cells
        self.shade_incorrect_cells()

        # Draw game ares
        self.draw_grid()

        # Draw NUmbers on Grid
        self.draw_numbers()

        # Set Cell Changed Flag to False
        self.cell_changed = False

        # Update Display
        pygame.display.update()


##########################################################################################
########################### Board Methods ################################################
##########################################################################################

    def check_all_done(self):
        # Loop over playing grid to check 0 values
        for posy in range(9):
            for posx in range(9):

                # Return False if value is zero
                if self.playing_grid[posx][posy] == 0:
                    return False

        # Return true if all values are travesserd and 0 is not found
        return True

    def check_duplicate_in_rows(self):
        # Loop Over all Rows
        for row in self.playing_grid:

            # Generate List without zeros since they are empty cells
            non_zero_row = list(filter(lambda x: x != 0, row))

            # Check the length of List verses length of set to check duplicates
            if len(non_zero_row) != len(set(non_zero_row)):
                self.incorrect_cell = self.selected_cell
                return True

        # Return False if all are correct
        self.incorrect_cell = None
        return False

    def check_duplicate_in_columns(self):
        for i in range(9):
            non_zero_column = [self.playing_grid[j][i]
                               for j in range(9) if self.playing_grid[j][i] != 0]

            # Check the length of List verses length of set to check duplicates
            if len(non_zero_column) != len(set(non_zero_column)):
                self.incorrect_cell = self.selected_cell
                return True

        # Reset incorrect cell and Return False if all are correct
        self.incorrect_cell = None
        return False

    def check_duplicate_in_grids(self):
        non_zero_grid = []

        # Looping on 1st element of all 3x3 grids
        for pos_y in range(0, 9, 3):
            for pos_x in range(0, 9, 3):

                # Generate Single list from 3x3 List
                for i in range(3):
                    for j in range(3):
                        if self.playing_grid[pos_x + i][pos_y + j] != 0:
                            non_zero_grid.append(self.playing_grid[pos_x + i][pos_y + j])

                # Chech for duplicates in the Flattened list
                if len(non_zero_grid) != len(set(non_zero_grid)):
                    self.incorrect_cell = self.selected_cell
                    return True

                # Reset flattened list
                non_zero_grid = []

        # Return false if all are correct
        self.incorrect_cell = None
        return False


##########################################################################################
########################### Helper Methods ###############################################
##########################################################################################

    # Draw Grid Method


    def draw_grid(self):
        # Draw Outside of Grid Dimensions in (x, y, width, height) form
        pygame.draw.rect(self.screen, BLACK,
                         (GAME_AREA["START-X"], GAME_AREA["START-Y"], WIDTH - 40, HEIGHT - 120), 3)

        for x in range(1, 9):
            if x % 3 == 0:
                stroke = 3
            else:
                stroke = 1

            # Draw Internal Horizontal Lines
            pygame.draw.line(self.screen, BLACK,
                             (GAME_AREA["START-X"], GAME_AREA["START-Y"] + (x * BOX_LENGTH)),
                             (GAME_AREA["END-X"], GAME_AREA["START-Y"] + (x * BOX_LENGTH)),
                             stroke)

            # Draw Internal Vrtical Lines
            pygame.draw.line(self.screen, BLACK,
                             (GAME_AREA["START-X"] + (x * BOX_LENGTH), GAME_AREA["START-Y"]),
                             (GAME_AREA["START-X"] + (x * BOX_LENGTH), GAME_AREA["END-Y"]),
                             stroke)

    # Method to draw selected cell

    def selected_cell_draw(self):
        if self.selected_cell:
            pygame.draw.rect(self.screen, PALE_BLUE, (
                GAME_AREA["START-X"] + self.selected_cell[0] * BOX_LENGTH,
                GAME_AREA["START-Y"] + self.selected_cell[1] * BOX_LENGTH,
                BOX_LENGTH,
                BOX_LENGTH
            ))

    # Check if mouse if on Grid

    def mouse_on_grid(self):
        if self.mouse_pos[0] > GAME_AREA["START-X"] and self.mouse_pos[0] < GAME_AREA["END-X"] \
                and self.mouse_pos[1] > GAME_AREA["START-Y"] and self.mouse_pos[1] < GAME_AREA["END-Y"]:
            cell_row = (self.mouse_pos[0] - GAME_AREA['START-X']) // BOX_LENGTH
            cell_col = (self.mouse_pos[1] - GAME_AREA['START-Y']) // BOX_LENGTH
            self.selected_cell = (cell_row, cell_col) if (
                cell_row, cell_col) not in self.locked_cells else None
        else:
            self.selected_cell = None

    # Method to check whether clicked on Button
    def mouse_on_button(self):
        for button in self.play_buttons:
            if button.is_mouse_here():
                button.exec_function()

    # Define method for loading buttons
    def load_buttons(self):
        self.play_buttons.append(Button(0, text='Reset', func=self.reset))
        self.play_buttons.append(Button(1, text='Solve', func=self.solver))

    # Draw Numbers

    def draw_numbers(self):
        for y_idx, row in enumerate(self.playing_grid):
            for x_idx, value in enumerate(row):
                x_pos = (x_idx * BOX_LENGTH) + PADD
                y_pos = (y_idx * BOX_LENGTH) + PADD
                self.text_on_grid([x_pos, y_pos], str(value) if value != 0 else ' ')

    # Function to display Text on screen

    def text_on_grid(self, pos, text):
        text = self.font_grid.render(text, True, BLACK)

        # Get text dimension for centering the text in cell
        text_height = text.get_height()
        text_width = text.get_width()

        # Get padding for text
        pos[0] += (BOX_LENGTH - text_width) // 2
        pos[1] += (BOX_LENGTH - text_height) // 2
        self.screen.blit(text, pos)

    # Load buttons

    def load(self):
        # Load Buttons
        self.load_buttons()

        # Populate list of locked cells
        for y_idx, row in enumerate(self.playing_grid):
            for x_idx, val in enumerate(row):
                if val != 0:
                    self.locked_cells.append((x_idx, y_idx))

    # Function to shade the locked cells

    def shade_locked_cells(self):
        for row_idx, col_idx in self.locked_cells:
            pos_x = row_idx * BOX_LENGTH + PADD
            pos_y = col_idx * BOX_LENGTH + PADD
            pygame.draw.rect(self.screen, GRAY, (pos_x, pos_y, BOX_LENGTH, BOX_LENGTH))

    # Function to shade Incorrect Cells

    def shade_incorrect_cells(self):
        if self.incorrect_cell:
            pygame.draw.rect(self.screen, PALE_RED, (
                GAME_AREA["START-X"] + self.incorrect_cell[0] * BOX_LENGTH,
                GAME_AREA["START-Y"] + self.incorrect_cell[1] * BOX_LENGTH,
                BOX_LENGTH,
                BOX_LENGTH
            ))
    ## Function to Solve Grid
    def solver(self):
        self.not_solved = True
        ## Y Co-ordinates
        for pos_y in range(9):
            ## X Co-ordinates
            for pos_x in range(9):
                ## Check if value is missing
                if self.playing_grid[pos_y][pos_x] == 0:
                    ## Loop values to check correct val
                    for val in range(1, 10):
                        if self.is_correct_value(pos_y, pos_x, val):
                            ## Put the value
                            self.playing_grid[pos_y][pos_x] = val

                            ## Testing with time
                            time.sleep(0.01)

                            # Recursive update
                            self.solver()

                            ## Testing with time
                            time.sleep(0.01)

                            ## If any incorrect value found, then set grid to 0
                            if self.not_solved:
                                self.playing_grid[pos_y][pos_x] = 0
                    
                    ## If all values are exhausted, return to previous position
                    ## This is necessary to return reursive function to avoid infinite looping
                    return
        ## Unset not Solved variable to avoid resetting all values to 0
        self.not_solved = False


    ## Helper function for Solver 
    def is_correct_value(self, y, x, val):
        ## Check in Row
        for pos_x in range(9):
            if self.playing_grid[y][pos_x] == val:
                return False
        
        ## Check in Column
        for pos_y in range(9):
            if self.playing_grid[pos_y][x] == val:
                return False
        
        ## Check in small Grid
        start_x = (x // 3) * 3
        start_y = (y // 3) * 3
        for posy in range(3):
            for posx in range(3):
                pos_y = start_y + posy
                pos_x = start_x + posx
                if self.playing_grid[pos_y][pos_x] == val:
                    return False
        
        ## If possible, return True
        return True