import pygame
import sys
from settings import *

## Define app class for Sudoku
class App():
    """App class for Sudoku Game"""

    def __init__(self):
        ## Initialize PyGame
        pygame.init()

        ## Set Running Variable for Pygame Looop
        self.running = True

        ## Create PyGame Screen
        self.screen = pygame.display.set_mode((WIDTH, HEIGHT))

        ## Set Mouse position tracker
        self.mouse_pos = None

        ## Selected Cell
        self.selected_cell = None

        ## Set Current State to Playing
        self.state = "PLAYING"


    ## Define run method
    def run(self):
        while self.running:
            if self.state == "PLAYING":
                self.playing_events()
                self.playing_update()
                self.playing_draw()

        ## Close window on Exit
        pygame.quit()
        sys.exit()


##########################################################################################
##################### Core Playing Methods ###############################################
##########################################################################################

    ## Define Events method
    def playing_events(self):
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                self.running = False
            if event.type == pygame.MOUSEBUTTONDOWN:
                self.mouse_on_grid()


    ## Define Update method
    def playing_update(self):
        self.mouse_pos = pygame.mouse.get_pos()


    ## Defime Draw Method
    def playing_draw(self):

        ## Fill White for Background
        self.screen.fill(WHITE)

        ## Draw game ares
        self.draw_grid()

        ## Show selected cell
        self.selected_cell_draw()

        ## Update Display
        pygame.display.update()


##########################################################################################
########################### Helper Methods ###############################################
##########################################################################################


    ## Draw Grid Method
    def draw_grid(self):
        ## Draw Outside of Grid Dimensions in (x, y, width, height) form
        pygame.draw.rect(self.screen, BLACK, (GAME_AREA["START-X"], GAME_AREA["START-Y"], WIDTH - 40, HEIGHT - 120), 2)

        for x in range(1, 9):
            if x % 3 == 0:
                stroke = 2
            else:
                stroke = 1
            
            ## Draw Internal Horizontal Lines
            pygame.draw.line(self.screen, BLACK, 
                (GAME_AREA["START-X"], GAME_AREA["START-Y"] + (x * BOX_LENGTH)),
                (GAME_AREA["END-X"] , GAME_AREA["START-Y"] + (x * BOX_LENGTH)), 
            stroke)

            ## Draw Internal Vrtical Lines
            pygame.draw.line(self.screen, BLACK, 
                (GAME_AREA["START-X"] + (x * BOX_LENGTH), GAME_AREA["START-Y"] ),
                (GAME_AREA["START-X"] + (x * BOX_LENGTH), GAME_AREA["END-Y"] ),
            stroke)
        
    
    ## Method to draw selected cell
    def selected_cell_draw(self):
        if self.selected_cell:
            pygame.draw.rect(self.screen, PALE_BLUE, (
                GAME_AREA["START-X"] + self.selected_cell[0] * BOX_LENGTH + 1,
                GAME_AREA["START-Y"] + self.selected_cell[1] * BOX_LENGTH + 1,
                BOX_LENGTH - 1,
                BOX_LENGTH - 1
            ))


    ## Check if mouse if on Grid
    def mouse_on_grid(self):
        if self.mouse_pos[0] > GAME_AREA["START-X"] and self.mouse_pos[0] < GAME_AREA["END-X"] \
            and self.mouse_pos[1] > GAME_AREA["START-Y"] and self.mouse_pos[1] < GAME_AREA["END-Y"]:
            cell_row = (self.mouse_pos[0] - GAME_AREA['START-X']) // BOX_LENGTH
            cell_col = (self.mouse_pos[1] - GAME_AREA['START-Y']) // BOX_LENGTH
            self.selected_cell = (cell_row, cell_col)
        else:
            self.selected_cell = None
    
