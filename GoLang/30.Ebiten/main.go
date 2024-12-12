package main

import (
	"log"

	"github.com/hajimehoshi/ebiten/v2"
)

// Some Constants
const (
	ScreenWidth  = 640
	ScreenHeight = 480
)

// Lets implement ebiten.Game interface
type SnakeGame struct{}

// Implement Draw method
func (g *SnakeGame) Draw(screen *ebiten.Image) {}

// Implement Update method
func (g *SnakeGame) Update() error {
	return nil
}

// Implement Layout
func (g *SnakeGame) Layout(outsideWidth, OutsideHeight int) (int, int) {
	return ScreenWidth, ScreenHeight
}

func main() {
	// Create snake game
	game := SnakeGame{}

	// Set Window Size
	ebiten.SetWindowSize(ScreenWidth, ScreenHeight)

	// Set Window Title
	ebiten.SetWindowTitle("Snake Game")
	// Run Game
	if err := ebiten.RunGame(&game); err != nil {
		log.Fatal(err)
	}
}
