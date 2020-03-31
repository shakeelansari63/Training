import pygame
from settings import *

class Button:
    
    def __init__(self, idx, width = BUTTON_WIDTH, height = BUTTON_HEIGHT, text = None, bg_color = DARK_BLUISH, 
                hower_bg_color = LIGHT_BLUISH, fg_color = WHITE,
                hower_fg_color = WHITE, func = None, params = None):
        self.image = pygame.Surface((width, height)) ## Create Empty Image Surface

        ## Calculate Button Positions based on given index
        posx = BUTTON_AREA['START-X'] + ( idx * ( BUTTON_WIDTH + PADD ) )
        posy = BUTTON_AREA['START-Y']
        self.pos = (posx, posy)    ## Set co-ordinates
        self.rect = self.image.get_rect()  ## Generate a rectangle from Image surface
        self.rect.topleft = self.pos  ## Set position of rectangle to the co-ordinates
        self.text = text if text is not None else ''   ## Set Default Button Text
        self.bg_color = bg_color  ## Set Default Button Color
        self.hower_bg_color = hower_bg_color  ## Set Default button hower color
        self.fg_color = fg_color     ## Set Text color
        self.hower_fg_color = hower_fg_color  ## Set text color when mouse hower
        self.func = func   ## Set Button call function
        self.params = params   ## Set Button call function parameters
        self.highlighted = False   ## Set highlighted variable assuming mouse does not hower

        ## Button Text render
        self.font_btn = pygame.font.Font('freesansbold.ttf', BUTTON_TEXT_SIZE)
        self.btn_text = self.font_btn.render(self.text, True, WHITE)

        txt_height = self.btn_text.get_height()
        txt_width = self.btn_text.get_width()

        ## Empty Button POsition List
        self.btn_txt_pos = []

        ## X POsition 
        self.btn_txt_pos.append((BUTTON_WIDTH - txt_width) // 2 + self.pos[0])

        ## Y Position
        self.btn_txt_pos.append((BUTTON_HEIGHT - txt_height) // 2 + self.pos[1])
        
    
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

        ## Draw Text
        screen.blit(self.btn_text, self.btn_txt_pos)

    def is_mouse_here(self):
        return self.highlighted

    def exec_function(self):
        self.func()
            
