package main

import (
	"fmt"
	"runtime"
	"sync"
	"time"
)

func main() {
	fmt.Println("GoRoutines")
	// Major issue with traditional OS tread is the system overhead causd by them.
	// Each thread has its own memory and scheduler
	// Go user a drifferent approach in threading
	// Go use Green thread which is abstraction of OS level thread, these are goruitines
	// Go runtime manager to schedule these goroutines on OS cpu cycle threads
	// Hence it is some what cheap compared to OS level threads
	// It also makes it easy to create since we don't have to deal with managing the underlying threads

	// To create a go routine, use the `go` keyword to execute a function
	go sayHello()

	// Now you will be disappointed since it did not print anything
	// The reason is mainthread completes even before child thread could run
	// And program ended
	// To avoid this, we can symply sleep for some time
	time.Sleep(100 * time.Millisecond)

	// We can do this with anonymous functions as well
	go func() {
		fmt.Println("Hello Anonymous")
	}()
	time.Sleep(100 * time.Millisecond)

	// One great thing is Go Routines have access to variables in main,
	// but we shoudld be carefull, if we change teh variable in main before go routine is run
	// it will take updated value
	msg := "Hello Message"
	go func() {
		fmt.Println(msg)
	}()
	msg = "Updated message"
	time.Sleep(100 * time.Millisecond)

	// We can avoid this by passing value parameter to function
	// Since value creates new instance in memory, it is no longer shared
	// It will use old value
	msg1 := "Hello Message"
	go func(msg1 string) {
		fmt.Println(msg1)
	}(msg1)
	msg1 = "Updated message"
	time.Sleep(100 * time.Millisecond)

	// Till now we have been waiting for goroutine with time.sleep
	// But this is not efficient for Production
	// In production, we can use WaitGroups
	// Here we add 1 to waitgroup, we don't tell it what goroutine we are adding,
	// we just add 1, meaning there is 1 goroutine we have to wait for
	// So when some goroutine calls wg.Done, it will decrement the value in wg
	// and if we don't have any value, it will end program
	wg1.Add(1)
	go func() {
		fmt.Println("Wait for me...")
		// sleep for 5 second
		time.Sleep(2 * time.Second)
		fmt.Println("I am done now...")

		// Complete the go routine by telling waiting group that we are done
		wg1.Done()
	}()

	// Wait for Waiting group
	wg1.Wait()

	// Mutexes are resources which are used to bring some order in applictions
	// Mutexes are resources which can be lokced and unlokced
	// So if some process want to update some resource, ard we don't want any other process to update at same time
	// We can have mutexes to magage locking for resources
	// And process will wait until it gets the lock
	for i := 0; i < 5; i++ {
		wg1.Add(3)
		go incrementBy1()
		go incrementBy2()
		go incrementBy3()
	}

	wg1.Wait()

	// There is no order if we don't lock or unlock mutex
	// Now lets use mutex
	counter = 0
	for i := 0; i < 5; i++ {
		wg1.Add(3)
		go incrementBy1WithMutex()
		go incrementBy2WithMutex()
		go incrementBy3WithMutex()
	}

	wg1.Wait()

	// We can manage maximum number of threads using runtime.MAXPROCS
	// Go gives us default n number of threads which is number of cpu cores
	// But we can increase and limit it
	fmt.Printf("Maximum threads by default: %v\n", runtime.GOMAXPROCS(-1))

	// We can set maxprocs
	runtime.GOMAXPROCS(20)
	fmt.Printf("Maximum threads by updated: %v\n", runtime.GOMAXPROCS(-1))
}

func sayHello() {
	fmt.Println("Hello World!!!")
}

// lets create a wait group now
// We will use this to sync the main with other goroutines and wait till tehy are compleetd
var wg1 = sync.WaitGroup{}

// Now lets say we want two methods accessing same resource
// and we want only 1 element to access it at a time
// we can create a mutex and manage using that
var mt = sync.RWMutex{}
var counter = 0

func incrementBy1() {
	counter++
	fmt.Println("Counter incremented by 1. Value is - ", counter)

	// Complete waiting group
	wg1.Done()
}

func incrementBy2() {
	counter += 2
	fmt.Println("Counter incremented by 2. Value is - ", counter)

	// Complete waiting group
	wg1.Done()
}

func incrementBy3() {
	counter += 3
	fmt.Println("Counter incremented by 3. Value is - ", counter)

	// Complete waiting group
	wg1.Done()
}

// Lest use mutex
func incrementBy1WithMutex() {
	// Lock mutex
	mt.Lock()
	counter++
	fmt.Println("Counter incremented by 1. Value is - ", counter)

	// Release or unlock mutex
	mt.Unlock()

	// Complete waiting group
	wg1.Done()
}

func incrementBy2WithMutex() {
	// Lock mutex
	mt.Lock()
	counter += 2
	fmt.Println("Counter incremented by 2. Value is - ", counter)

	// Release or unlock mutex
	mt.Unlock()

	// Complete waiting group
	wg1.Done()
}

func incrementBy3WithMutex() {
	// Lock mutex
	mt.Lock()
	counter += 3
	fmt.Println("Counter incremented by 3. Value is - ", counter)

	// Release or unlock mutex
	mt.Unlock()

	// Complete waiting group
	wg1.Done()
}
