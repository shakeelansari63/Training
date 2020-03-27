import pygame
from settings import *

class Button:
    
    def __init__(self, idx, width = BUTTON_WIDTH, height = BUTTON_HEIGHT, text = None, bg_color = DARK_BLUISH, 
                hower_bg_color = LIGHT_BLUISH, fg_color = WHITE,
                hower_fg_color = WHITE, function = None, params = None):
        self.image = pygame.Surface((width, height)) ## Create Empty Image Surface

        ## Calculate Button Positions based on given index
        posx = BUTTON_AREA['START-X'] + ( idx * ( BUTTON_WIDTH + PADD ) )
        posy = BUTTON_AREA['START-Y']
        self.pos = (posx, posy)    ## Set co-ordinates
        self.rect = self.image.get_rect()  ## Generate a rectangle from Image surface
        self.rect.topleft = self.pos  ## Set position of rectangle to the co-ordinates
        self.text = text   ## Set Default Button Text
        self.bg_color = bg_color  ## Set Default Button Color
        self.hower_bg_color = hower_bg_color  ## Set Default button hower color
        self.fg_color = fg_color     ## Set Text color
        self.hower_fg_color = hower_fg_color  ## Set text color when mouse hower
        self.func = function   ## Set Button call function
        self.params = params   ## Set Button call function parameters
        self.highlighted = False   ## Set highlighted variable assuming mouse does not hower

    
    def update(self, mouse_pos):
        ## Collidepoint checks if mouse position is on rectangle
        if self.rect.collidepoint(mouse_pos):
            self.highlighted = True
        else:
            self.highlighted = False

    def draw(self, screen):
        ## Set Button color based on mouse position
        self.image.fill(self.hower_bg_color if self.highlighted else self.bg_color)

        ## Draw the button
        screen.blit(self.image, self.pos)
