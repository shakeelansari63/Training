package main24

import (
	"fmt"
	"reflect"
)

func main() {
	i := 1
	t := reflect.TypeOf(i)
	fmt.Println(t)
}
