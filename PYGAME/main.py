import pygame
import random


## Initialize the Pygame Module
pygame.init()


## Create the screen
screen = pygame.display.set_mode((800, 600))


## Import image for background
bg = pygame.image.load('assets/bg.png')


## Change Window Title
pygame.display.set_caption("Space Invader")


## Change Title Icon
icon = pygame.image.load('assets/rocket.png')
pygame.display.set_icon(icon)


## Player Configurations
player_img = pygame.image.load('assets/player.png')
player_posx = 368   ## 368 is for displaying player in center (800 / 2) - (64 / 2)
player_posy = 456   ## Display player 80 pixel above bottom 600 - 80 - 64
player_min_posx = 10  ## Left padding of 10 px
player_max_posx = 726  ## Right padding of 10 px + side of player
move_player = 0   ## To avoid player moving as soon as screen load
player_speed = 1

def player():
    ## Blit function draws the image
    screen.blit(player_img, (player_posx, player_posy))


## Enemy Configuration
enemy_img = pygame.image.load('assets/alien.png')
enemy_min_posx = 10   ## Left padding of 10 px
enemy_max_posx = 726  ## Right padding of 10 px + size of enemy i.e. 64 800 - 10 - 64
enemy_min_posy = 40   ## Top padding of 40 px
enemy_max_posy = 150  ## Enemy can generate till mid of screen
enemy_posx = random.randint(enemy_min_posx, enemy_max_posx)   ## Random X Position
enemy_posy = random.randint(enemy_min_posy, enemy_max_posy)   ## Random Y Position

enemy_speed = 1.2
move_enemy = enemy_speed ## To move enemy as soon as screen load
move_enemy_down = 32 ## Move enemy down by 32 px

def enemy():
    screen.blit(enemy_img, (enemy_posx, enemy_posy))


## As soon as Screen is created, pygame closes automatically
## In order to avoid that, following infinite loop is needed

# Initialize a variable to true for running infinite loop
run_status = True
while run_status:
    ## Change screen background colour
    screen.fill((20, 20, 20))

    ## Display Background Image
    screen.blit(bg, (0, 0))

    ## Now following loop is to get all events
    for event in pygame.event.get():
        ##  unset run status when quit button is closed hence killing the loop
        if event.type == pygame.QUIT:
            run_status = False
        ## Catch key stroke and set movement of player
        elif event.type == pygame.KEYDOWN:
            if event.key == pygame.K_LEFT:
                move_player = -1 * player_speed ## Negative speed to move left
            elif event.key == pygame.K_RIGHT:
                move_player = player_speed ## Positive speed to move right
        
        elif event.type == pygame.KEYUP:
            if event.key in (pygame.K_LEFT, pygame.K_RIGHT):
                move_player = 0   ## reset speed to stop moving


    ## Changing the player position based on move player variable
    ## This is here to make sure the player keep moving unless 
    ## value is reset by key up event
    if player_posx + move_player < player_min_posx:
        player_posx = player_min_posx ## Left boundary for player
    elif player_posx + move_player >  player_max_posx:
        player_posx = player_max_posx ## Right boundary for player
    else:
        player_posx += move_player
    player()


    ## Display Enemy
    if enemy_posx + move_enemy < enemy_min_posx:
        enemy_posx = enemy_min_posx
        enemy_posy += move_enemy_down
        move_enemy = enemy_speed
    elif enemy_posx + move_enemy > enemy_max_posx:
        enemy_posx = enemy_max_posx
        enemy_posy += move_enemy_down
        move_enemy = -1 * enemy_speed
    else:
        enemy_posx += move_enemy
    enemy()

    ## This will keep updating the display window for every changes user make
    pygame.display.update()