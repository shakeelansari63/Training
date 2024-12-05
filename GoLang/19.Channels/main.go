package main

import (
	"fmt"
	"sync"
)

// Lets start with waitgroup
var wg = sync.WaitGroup{}

func main() {
	fmt.Println("Channels")

	// Channels are designed to synchronise data transmission between GoRoutines
	// Channels can only be created using make function
	// Also channles are troongly typed,
	// so one type of channel can transmit data of taht type only

	ch := make(chan int)

	// Add 2 to wait groups for 2 go routines which we are going to use
	wg.Add(2)

	// Lets create sending goroutine which will send data via channel
	go func() {
		data := 10
		ch <- data // Send data to channel

		// When we are passing data via channel, it is coping data
		// So even if we change variable data now, it wont affect what is sent
		data = 47

		wg.Done()
	}()

	// Lets create receiving goroutine which will receive data
	go func() {
		i := <-ch // Receive data from channle and load to another variable
		fmt.Println("Got data from channel: ", i)
		wg.Done()
	}()

	wg.Wait()

	// Here Sender function can also receive teh channel data and vice versa
	// So if we want to restrict the goroutine to either send only or receive only
	// We can do it in function parameter
	wg.Add(2)
	// Receiving only
	go func(ch <-chan int) {
		i := <-ch
		fmt.Println("Channel value is :", i)
		wg.Done()
	}(ch)

	//Sender only
	go func(ch chan<- int) {
		ch <- 42
		wg.Done()
	}(ch)

	wg.Wait()

	// Till now we have worked with unbuffered channle
	// Meaning there can be only one value in channel
	// i.e. unless a consumer goroutine consume the value form channel,
	// other goroutines cannot be able to write anything to channel
	// And if writer reach the `ch<-42` it actually stops execution
	// unless it is able to write to channle
	// Similarly if code reach `i:= <-ch` it stops untill it is able to read from channel
	// Hence if there are no receiver and sender is stuck at writing position, deadlock is created

	// To solve this issue, we can have channel of bigger length
	// And data will be buffered in the channel untill it is retrieved
	ch2 := make(chan int, 10) // Can accomodate 10 values

	wg.Add(2)
	go func(ch <-chan int) {
		i := <-ch // Single receiver
		fmt.Println("Receiving form big channel: ", i)
		wg.Done()
	}(ch2)

	go func(ch chan<- int) {
		// Send multiple values to channel
		ch <- 47 // Receiver will receive only this value as there is only 1
		ch <- 28 // So this will be ignored
		wg.Done()
	}(ch2)

	wg.Wait()

	// Now we have many masseges in channel, how do we handle them
	// We can loop over channel using range syntax and take every single value
	// But problem with looping over channel is it will keep waiting for closure of channel
	// and if channel is not closed explicitly, deadlock condition will occur again
	// when all elements are exhausted
	wg.Add(2)
	ch3 := make(chan int, 10)

	// Receiver with loop
	go func(ch <-chan int) {
		// See don't have key when looping over channel like we have for arrays, slices or maps
		// here we only get 1 value which we are collecting in i
		for i := range ch {
			fmt.Println("Looping on Channel, value is: ", i)
		}
		wg.Done()
	}(ch3)

	// Sender sending many messages
	go func(ch chan<- int) {
		ch <- 10
		ch <- 15
		ch <- 12
		ch <- 37
		ch <- 42
		ch <- 54
		ch <- 75
		ch <- 69
		ch <- 88
		ch <- 91
		ch <- 104

		// It is necessary to explicitly close channel to tell receiver that channel has no new input
		close(ch)
		wg.Done()
	}(ch3)

	wg.Wait()

	// Channels can also have default value if they are closed early
	ch4 := make(chan int)

	wg.Add(2)

	go func() {
		// This will print 0
		fmt.Printf("Default value from closed channel is %d\n", <-ch4)
		wg.Done()
	}()
	go func() {
		close(ch4)
		wg.Done()
	}()
	wg.Wait()

	// But how would we know whether this 0 is from closed channel or is actual value from channel
	// For this, we should collect the channel value in a varible with 2nd parameter which tells whetehr channel is open
	ch5 := make(chan int)
	wg.Add(2)

	go func() {
		// This will print 0
		i, isOpen := <-ch5
		fmt.Printf("Default value from closed channel is %d, and the channel open status is - %v\n", i, isOpen)
		wg.Done()
	}()
	go func() {
		close(ch5)
		wg.Done()
	}()
	wg.Wait()
}
