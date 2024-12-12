## Ebiten (EbitEngine) is a Game development engine for Go

## Install Ebiten

```
go get github.com/hajimehoshi/ebiten/v2
```

### Ebiten RunGame need a struct which implements ebiten.Game interface

```go
// ebiten.go
type Game interface {
    Draw(screen *ebiten.Image) // This has logic to draw in screen which is an Image tyoe

    Update() error // This has logic to update game state

    Layout(outsideWidth, outsideHeight int) (int, int) // This is called if window size is changes, and used to update game layout accordingly if needed
}
```
