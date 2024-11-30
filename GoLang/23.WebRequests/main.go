package main

import (
	"fmt"
	"io"
	"net/http"
	"net/url"
)

const url1 string = "https://ip4.me/"
const url2 string = "https://me.dev:3000/learn?lang=golang&mod=net"

func main() {
	fmt.Println("Lets learn how to invoke web requests from Golang")

	// We will use net/http package for making web requests
	response, err := http.Get(url1)
	handleError(err)

	// The response received from Http is object of type *http.Response
	// And it is necessary to make sure to close the connection after reading the response
	// because Go does not automatically does so

	// Lets defer the connection closure to make sure it is closed at end
	defer response.Body.Close()

	// We can read the status code of response using
	if response.StatusCode != 200 {
		// If response code is not 200 i.e. for success, then we can close the program
		panic("Error in reading Api")
	}

	// To read the response content, we use io module
	content, err := io.ReadAll(response.Body)
	handleError(err)

	// And because IO module reads content in bytes, we can convert it to string
	fmt.Println(string(content))

	// We can also use net module to work with URLs.
	// For example we can parse URLs
	parsedUrl, err := url.Parse(url2)
	handleError(err)

	// And we can see multiple parts of URL
	fmt.Println("URL Scheme:", parsedUrl.Scheme)
	fmt.Println("URL Host:", parsedUrl.Host)
	fmt.Println("URL Port:", parsedUrl.Port())
	fmt.Println("URL Raw Query:", parsedUrl.RawQuery)

	// This is good, we can parse and deconstruct URL but the Query parameters are not looking clean
	// URL parameter provide a mechanism to convert the Query parameters to map
	qparams := parsedUrl.Query()

	// And we can loop over this map
	for key, val := range qparams {
		fmt.Println("Value of Key:", key, "is", val)
	}

	// And it is also possible to construct URL string from parts
	// It is necessary to remeber, when we use url.Url, we have to use Address type

	urlParts := &url.URL{
		Scheme:   "https",
		Host:     "me.dev",
		Path:     "test",
		RawQuery: "style=1&type=2",
	}

	// We can then call the String method on urlParts to construct URL string
	fmt.Println("Constructed url is - ", urlParts.String())
}

func handleError(err error) {
	if err != nil {
		panic(err)
	}
}
