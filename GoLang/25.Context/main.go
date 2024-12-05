package main

import (
	"context"
	"fmt"
	"io"
	"net/http"
	"time"
)

func main() {
	fmt.Println("Working with Context")

	// Contexts are mechanism to cancel some running process
	// For example, lets see we have a method to read some file form HTTP
	req1, err := http.NewRequest(http.MethodGet, "https://via.placeholder.com/2000x2000", http.NoBody)
	if err != nil {
		panic(err)
	}

	res1, err := http.DefaultClient.Do(req1)
	if err != nil {
		panic(err)
	}

	// Close connection
	defer res1.Body.Close()

	imageData1, err := io.ReadAll(res1.Body)
	if err != nil {
		panic(err)
	}
	fmt.Printf("Image Size is %d\n", len(imageData1))

	// This will return size of image
	// But lets imagine, we don't want to give the API request only 100ms,
	// it if takes more time than 100ms, we want to close the connection.
	// How do we do it?
	// Here we can use context
	// We will see With Timeout context here
	// This returns us 2 items, the context and cancel function which need to be defered to run at end
	// Here context.Background is Go's built in Context for running something in background
	timeoutContext, cancel := context.WithTimeout(context.Background(), time.Millisecond*100)
	defer cancel()

	// Http library comes with some methods which can utilize context
	req2, err := http.NewRequestWithContext(timeoutContext, http.MethodGet, "https://via.placeholder.com/2000x2000", http.NoBody)
	if err != nil {
		panic(err)
	}

	res2, err := http.DefaultClient.Do(req2)
	if err != nil {
		panic(err)
	}

	// Close connection
	defer res2.Body.Close()

	imageData2, err := io.ReadAll(res2.Body)
	if err != nil {
		panic(err)
	}
	fmt.Printf("Image Size is %d\n", len(imageData2))

	// And for second time, you will notice the deadline exceeded error
}
