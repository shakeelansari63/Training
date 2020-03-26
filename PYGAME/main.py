import pygame
import random
import math


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
player_speed = 4

def player():
    ## Blit function draws the image
    screen.blit(player_img, (player_posx, player_posy))


## Enemy Configuration

## List for multiple enemies
enemy_img = []
enemy_min_posx = 10   ## Left padding of 10 px
enemy_max_posx = 726  ## Right padding of 10 px + size of enemy i.e. 64 800 - 10 - 64
enemy_min_posy = 40   ## Top padding of 40 px
enemy_max_posy = 150  ## Enemy can generate till mid of screen
enemy_posx = []   ## Random X Position
enemy_posy = []   ## Random Y Position

enemy_speed = 1.2
move_enemy = [] ## To move enemy as soon as screen load
move_enemy_down = 32 ## Move enemy down by 32 px
number_of_enemies = 6

for i in range(number_of_enemies):
    enemy_img.append(pygame.image.load('assets/alien.png'))
    enemy_posx.append(random.randint(enemy_min_posx, enemy_max_posx))
    enemy_posy.append(random.randint(enemy_min_posy, enemy_max_posy))
    move_enemy.append(enemy_speed)

def enemy(indx):
    screen.blit(enemy_img[indx], (enemy_posx[indx], enemy_posy[indx]))


def new_enemy(indx):
    global enemy_posx
    global enemy_posy 
    enemy_posx[indx] = random.randint(enemy_min_posx, enemy_max_posx)   ## Random X Position
    enemy_posy[indx] = random.randint(enemy_min_posy, enemy_max_posy)   ## Random Y Position

## Enemy Configuration
bullet_img = pygame.image.load('assets/bullet.png')
bullet_min_posx = 42   ## Left padding of 10 px + 32 px to bring it tip of player
bullet_max_posx = 758  ## Right padding of 10 px + size of enemy i.e. 64 800 - 10 - 32
bullet_min_posy = 40   ## Padding top fot bullet
bullet_posx = 0   ## Don't know the start Position
bullet_posy = 424   ## Y position start at tip of player

bullet_speed = 6
move_bullet = bullet_speed ## To move enemy as soon as screen load

bullet_state = 'READY'

# Display bullet on Screen and set state to fired
def fire_bullet():
    global bullet_state
    bullet_state = 'FIRED'
    screen.blit(bullet_img, (bullet_posx, bullet_posy))

# Reset Bullet state
def bullet_ready():
    global bullet_state
    global bullet_posy
    bullet_state = 'READY'
    bullet_posy = 424

# Check if Bullet has collided with enemy
def enemy_colision(indx):
    enemy_hit_x = enemy_posx[indx] + 32
    enemy_hit_y = enemy_posy[indx] + 32
    bullet_hit_x = bullet_posx + 16
    bullet_hit_y = bullet_posy + 5

    enemy_bullet_distance = math.sqrt( math.pow(enemy_hit_x - bullet_hit_x, 2) 
                                        + math.pow(enemy_hit_y - bullet_hit_y, 2) )

    return enemy_bullet_distance < 27


## Displaying the score
font = pygame.font.Font('freesansbold.ttf', 32) ## Font name and size
score_value = 0
score_posx = 10
score_posy = 10

def show_score():
    text = font.render("Score: " + str(score_value), True, (255, 255, 255))
    screen.blit(text, (score_posx, score_posy))


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

            ## Move Player Right for Right Button
            elif event.key == pygame.K_RIGHT:
                move_player = player_speed ## Positive speed to move right
            
            ## Fire new bullet if space is pressed and previous bullet in ready state
            elif event.key == pygame.K_SPACE and bullet_state == 'READY':
                bullet_posx = player_posx + 16 ## Set Bullet X Position to X+16 of Player
                fire_bullet()
        
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
    for i in range(number_of_enemies):
        if enemy_posx[i] + move_enemy[i] < enemy_min_posx:
            enemy_posx[i] = enemy_min_posx
            enemy_posy[i] += move_enemy_down
            move_enemy[i] = enemy_speed
        elif enemy_posx[i] + move_enemy[i] > enemy_max_posx:
            enemy_posx[i] = enemy_max_posx
            enemy_posy[i] += move_enemy_down
            move_enemy[i] = -1 * enemy_speed
        else:
            enemy_posx[i] += move_enemy[i]
        enemy(i)

        ## Check if Bullet hit Enemy
        if enemy_colision(i):
            bullet_ready()
            new_enemy(i)
            score_value += 1

    ## Display bullet only if it is in ready state and reset bullet state if it reach screen edge
    if bullet_state == 'FIRED':
        if bullet_posy - move_bullet < bullet_min_posy:
            bullet_posy = bullet_min_posy
            fire_bullet()
            bullet_ready()
        else:
            bullet_posy -= move_bullet
            fire_bullet()
    
    ## Display Score always
    show_score()

    ## This will keep updating the display window for every changes user make
    pygame.display.update()