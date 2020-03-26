# PyGame Basics
  
## Import Pygame and Mixer for music
```python
import pygame
from pygame import mixer

## Initialize the Pygame Module
```python
pygame.init()  
```  
  
## Create the screen
```python
screen = pygame.display.set_mode((800, 600))  
```  
  
## Create background music
```python
mixer.music.load('background.wav')
mixer.music.play(-1) ## -1 runs it in loop
```
  
## Change Window Title
```python
pygame.display.set_caption("Game Name")
```
  
## Change Title Icon
```python
icon = pygame.image.load('icon.png')
pygame.display.set_icon(icon)
```  
  
## Display Image on Screen
```python
screen.blit(pygame.image, (x axis, y axis))
```

## Create one off sound
```python
music = mixer.Sound('sound.wav')
music.play()
```

## Window Loop
As soon as Screen is created, pygame closes automatically. In order to avoid that, an infinite loop is needed.  
  
All events are captured and actioned in this loop as this refresh the screen on next cycle.
  
```python
run_status = True
while run_status:
     ## Now following loop is to get all events
    for event in pygame.event.get():
        ##  unset run status when quit button is closed hence killing the loop
        if event.type == pygame.QUIT:
            run_status = False

    ## Refresh Display Screen
    pygame.display.update()
```
  
## Capture key press
```python
for event in pygame.event.get():
    if event.type == pygame.KEYDOWN:
        if event.key == pygame.K_LEFT:
            ## Some Acion
```  

## Draw Rectangle
Rectange take minimum 3 parameters  
1. Surface on which to draw  
2. Color in RGB Tuple  
3. Tuple of (  
  Start X Position,  
  Start Y Position,  
  Width of Rectangle,  
  Height of Rectangle  
)  
4. Optional parameter of Stroke. Default is to fill the rectangle  
```python
# Create square with length 50 from position 20, 20 with stroke of 2
pygame.draw.rect(screen, (255, 0, 0), (20, 20, 50, 50), 2)
```  
  
## Draw Line
Line need minimum 4 parameters
1. Surface on which to draw  
2. Color in RGB Tuple  
3. Tuple of (  
    Start X Position,  
    Start Y Position   
)  
4. Tuple of (
    End X Position,  
    End Y Position  
)  
5. Optional parameter of Stroke. Default is 1.
```python
## Draw line from (20, 100) to (20, 150) with stroke 5
pygame.draw.line(screen, (255, 0, 0), (20, 100), (30, 150), 5)
```  
  
## On Exit clean Closure
```python
pygame.quit()
sys.exit()
```