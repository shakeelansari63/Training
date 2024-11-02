package main

import (
	"fmt"
	"time"
)

func main() {
	// Time
	fmt.Println("----- Time -----")
	// Lets see how to handle time in Go
	// Go has library `time` for managing dates and times
	currentTime := time.Now()

	// Whats is in this current time
	fmt.Println("Current Time:", currentTime)

	// This returns the raw time, what if we just want to format it as per our taste
	// For time formatting Go uses a unique format option
	// We just need to remember 1  2  3  4  5  6  -7
	// What does that mean?
	// 1 - Jan (used for month)
	// 2 - 2nd (used for day)
	// 3 - 03 or 15 (used for hour)
	// 4 - 04 (used for minute)
	// 5 - 05 (used for second)
	// 6 - 2006 (used for year)
	// -7 - -7:00 UTC or 0 MST (Used for Timezone)
	// So a ISO time format string would look like "2006-01-02 15:04:05 -0700"
	fmt.Println("Current time is:", currentTime.Format("02/01/2006"))

	// Time package also allow us to create some new times
	// And we can use Day names and Month names if we need in that format
	// Remember 2nd Jan 2006 was Monday, so we have to use Mon or Monday for day name
	newTime := time.Date(2022, time.June, 5, 0, 0, 0, 0, time.Local)
	fmt.Println("New Date time is: ", newTime.Format("Mon 02 January 2006"))
}
