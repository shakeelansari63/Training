# Go Lang Tutorial

A comprehensive hands-on tutorial for learning the Go programming language, organized as numbered scripts from basics to advanced topics.

---

## Prerequisites

- Install Go from [https://go.dev/dl/](https://go.dev/dl/)
- Add Go binary path to your `PATH`
- Verify installation: `go version`
- A code editor (VS Code recommended with Go extension)

## How to Use This Tutorial

Each folder is a standalone Go program with its own `go.mod`. Navigate into any folder and run:

```bash
go run main.go
```

Read through the comments in each `main.go` — they explain every concept inline as code is executed.

---

## 01 - Hello World

**Folder:** `01.HelloWorld/`

The simplest Go program. Every Go executable starts with `package main` — this tells Go to compile the code into a runnable binary rather than a reusable library. The `import "fmt"` statement brings in the standard library's formatted I/O package, which provides `Print()`, `Println()`, and `Printf()` functions. The `func main()` is the entry point — execution begins here and the program exits when this function returns.

```go
package main
import "fmt"
func main() {
    fmt.Print("Hello World !!!")
}
```

**Key concepts:** package declaration, imports, function definitions, string literals.

---

## 02 - Variables

**Folder:** `02.Variables/`

Go is statically typed — every variable has a fixed type known at compile time. This script covers all of Go's primitive data types and declaration syntaxes.

**Declaration forms:**
- `var name type` — declares with zero value (e.g., `0` for int, `""` for string)
- `var name type = value` — declares and initializes
- `var name = value` — type inference (Go figures out the type from the value)
- `name := value` — shorthand (only inside functions)

**Numeric types:**
- Signed integers: `int8` (-128 to 127), `int16`, `int32`, `int64`, `int` (platform-dependent: 32-bit or 64-bit)
- Unsigned integers: `uint8` (alias `byte`), `uint16`, `uint32`, `uint64`, `uint`
- Floats: `float32`, `float64`
- Complex: `complex64` (two float32 parts), `complex128` (two float64 parts)
- `real()` and `imag()` extract real/imaginary parts

**Other types:**
- `string` — UTF-8 encoded text (double quotes `"..."` or raw backticks `` `...` ``)
- `rune` — a single Unicode code point (alias for `int32`, uses single quotes `'a'`)
- `bool` — `true` or `false`

**Type conversion:** Go has no implicit type casting. Even `int` and `int8` must be explicitly converted: `float32(intVar)`. Converting an `int` directly to `string` gives the Unicode character for that code point — use `strconv.Itoa()` for numeric strings.

**Multi-variable:** You can declare multiple variables of the same type in one line (`var a, b int`) or use a `var()` block for mixed types.

**Scope:** Variables declared outside functions (`var globalVar`) have package-level scope.

---

## 03 - Constants

**Folder:** `03.Constants/`

Constants are immutable values determined at compile time. Declared with `const`, they cannot use runtime-computed values (e.g., `math.Sin(10)` won't compile).

**iota:** Go's constant generator. Within a `const` block, `iota` starts at 0 and increments by 1 for each new line.

```go
const (
    a = iota  // 0
    b = iota  // 1
    c = iota  // 2
)
```

Since `iota` propagates to subsequent lines implicitly, you can write:
```go
const (
    _ = iota  // skip 0
    q         // 1
    w         // 2
)
```

**iota with expressions:** `iota` can be used in arithmetic to generate sequences:
```go
const (
    ev1 = (iota + 1) * 2  // 2
    ev2                    // 4
    ev3                    // 6
)
```

---

## 04 - Exported Names

**Folder:** `04.ExportedNames/`

Go determines visibility by the **first character** of a name:
- **Capital letter** = exported (public, accessible from other packages)
- **Lowercase** = unexported (private to the package)

This is why `fmt.Println()` starts with a capital P — `Println` is exported from the `fmt` package. If a function or variable starts with a lowercase letter, it cannot be accessed outside its own package, even if the package is imported.

---

## 05 - User Inputs

**Folder:** `05.UserInputs/`

Reading user input from the terminal:

1. Create a buffered reader: `bufio.NewReader(os.Stdin)` — wraps stdin for efficient reads
2. Read until newline: `reader.ReadString('\n')` — returns everything typed until Enter
3. Handle the two return values: `input, err := reader.ReadString('\n')`
4. Or ignore errors: `input, _ := reader.ReadString('\n')`

**Go's error handling philosophy:** Functions that can fail return an error as their last return value rather than throwing exceptions. You check `err` explicitly with `if err != nil` and decide what to do. This makes error paths visible in the code rather than hidden in try/catch blocks.

---

## 06 - Data Conversion

**Folder:** `06.DataConversion/`

Converting string input to numeric types is essential for CLI programs.

**Parsing functions in `strconv`:**
- `strconv.ParseFloat(s, bitSize)` — returns `(float64, error)`
- `strconv.ParseInt(s, base, bitSize)` — returns `(int64, error)`
- `strconv.Atoi(s)` — shortcut for `ParseInt(s, 10, 0)`

**The newline trap:** When reading from stdin, `ReadString` includes the trailing `\n` in the returned string. Attempting to parse `"42\n"` as a number fails. Always trim: `strings.TrimSpace(input)`.

**Pattern:**
```go
input, _ := reader.ReadString('\n')
value, err := strconv.ParseFloat(strings.TrimSpace(input), 64)
if err != nil {
    fmt.Println("Error:", err)
} else {
    fmt.Println("Result:", value)
}
```

---

## 07 - Operators

**Folder:** `07.Operators/`

**Arithmetic:** `+`, `-`, `*`, `/`, `%` — operator precedence matches C. Integer division truncates toward zero.

**Bitwise:** `&` (AND), `|` (OR), `^` (XOR), `&^` (AND NOT / bit clear — "turn off bits where the right operand has 1s").

**Shift:** `<<` (left shift, multiplies by 2^n), `>>` (right shift, divides by 2^n for unsigned).

**String operations:**
- Concatenation: `"hello" + " " + "world"`
- Indexing: `s[2]` returns a `byte` (uint8), not a character
- Byte slice: `[]byte(s)` converts a string to its underlying byte array

---

## 08 - Arrays & Slices

**Folder:** `08.ArraysSlices/`

**Arrays:** Fixed-length, value type. `[3]int{1,2,3}` creates an array of exactly 3 ints.

- `arr[i]` — index access
- `len(arr)` — number of elements
- `[...]int{1,2,3}` — compiler counts the elements for you
- Multi-dimensional: `[3][3]int`
- **Copy semantics:** `b := a` copies the **entire** array. Modifying `b` does not affect `a`.

**Slices:** Dynamic-length, reference type. `[]int{1,2,3}` (notice no size).

- Slices are backed by an underlying array
- **Copy semantics:** `s2 := s1` creates a reference. Modifying `s2` **does** affect `s1`.
- `len(s)` — number of elements currently in the slice
- `cap(s)` — number of elements the underlying array can hold
- `make([]int, length, capacity)` — create a slice with reserved capacity

**Slicing syntax (works on both arrays and slices):**
- `s[:]` — all elements
- `s[4:]` — index 4 to end
- `s[:5]` — start to index 4 (exclusive)
- `s[2:7]` — index 2 to 6 (exclusive)

**Append:** `s = append(s, 1, 2, 3)` — grows the slice as needed. Spread another slice: `s = append(s, other...)`.

**Remove elements (no built-in, use slicing):**
- First: `s = s[1:]`
- Last: `s = s[:len(s)-1]`
- Nth: `s = append(s[:n], s[n+1:]...)`

---

## 09 - Maps & Structs

**Folder:** `09.MapsStructs/`

### Maps

Maps associate keys with values. All keys must have the same type, and all values must have the same type.

- Declaration: `map[string]int`, `map[int]string`, etc.
- Literal: `map[string]int{"a": 1, "b": 2}`
- Create with `make`: `m := make(map[string]int)`

**Key existence check (comma-ok idiom):**
```go
value, ok := myMap["key"]
if !ok {
    // key doesn't exist; value is the zero value
}
```

- `delete(m, "key")` — removes a key-value pair
- Maps are **reference types** — assigning a map to another variable shares the underlying data
- Keys can be any comparable type (all numeric types, strings, booleans, arrays). Slices cannot be keys.

### Structs

Structs group related data fields together. They are **value types** — assignment copies the entire struct.

```go
type Person struct {
    Name    string
    Age     int
    Friends []string
}
```

**Anonymous structs** — useful for one-off data shapes:
```go
p := struct {
    Name string
    Age  int
}{Name: "Bob", Age: 30}
```

**Composition (embedding):** Instead of inheritance, Go embeds one struct inside another. All fields and methods of the embedded struct are promoted to the outer struct:
```go
type Employee struct {
    Person     // embedded — fields promoted
    EmployeeID int
}
// e.Name works, not just e.Person.Name
```

**Struct tags:** Metadata attached to fields, accessible via `reflect.TypeOf()`:
```go
type User struct {
    ID   int    `required max:999`
    Name string
}
```

---

## 10 - If and Switch

**Folder:** `10.IfAndSwitch/`

### If

Standard if-else with `&&` (AND), `||` (OR), `!` (NOT):
```go
if num <= 5 {
    // ...
} else if num <= 10 {
    // ...
} else {
    // ...
}
```

**If with initializer:** A common Go idiom that scopes variables to the if block:
```go
if value, ok := myMap["key"]; ok {
    // value is available here
} else {
    // value is NOT available here (new scope)
}
```

**Short-circuit:** In `a || b`, if `a` is true, `b` is never evaluated. In `a && b`, if `a` is false, `b` is never evaluated.

### Switch

Go's switch is more flexible than C's:
- **No implicit fallthrough** — no need for `break` after each case
- **Multi-case:** `case 1, 3, 5:`
- **Switch with initializer:** `switch n := compute(); n { ... }`
- **Switch on inequalities:** `switch { case num > 5: ... }`
- **`fallthrough`** — explicitly continues to the next case (rarely used)
- **Type switch:** `switch v.(type) { case int: ... case string: ... }` — switches on the dynamic type of an interface value

---

## 11 - Loops

**Folder:** `11.Loops/`

Go has a single looping construct: `for`. No `while` or `do-while`.

**Four forms:**

1. **Classic three-part:**
   ```go
   for i := 0; i < 10; i++ { ... }
   ```

2. **Condition-only (like while):**
   ```go
   for j < 5 {
       // ...
       j++
   }
   ```

3. **Infinite (break to exit):**
   ```go
   for {
       // ...
       if condition { break }
   }
   ```

4. **Range (iterate over collections):**
   ```go
   for index, value := range slice { ... }
   for key, value := range myMap { ... }
   ```

**Multi-variable for:**
```go
for i, j := 1, 1; i <= 6 && j <= 10; i, j = i+1, j*i { ... }
```
Note the comma-separated assignment (not parallel assignment with `:=`).

---

## 12 - Defer

**Folder:** `12.Defer/`

`defer` postpones execution of a function until the surrounding function returns. It's primarily used for cleanup — closing files, releasing network connections, unlocking mutexes.

**Key behaviors:**

1. **Arguments are evaluated immediately**, not when the deferred call runs:
   ```go
   a := "start"
   defer fmt.Println(a)  // prints "start"
   a = "end"
   ```

2. **Deferred calls are stacked (LIFO):**
   ```go
   defer fmt.Println("first")   // prints third
   defer fmt.Println("second")  // prints second
   defer fmt.Println("third")   // prints first
   ```

3. **Deferred functions run even if the function panics** — this is the basis of Go's panic/recover pattern.

**Common pattern:**
```go
file, err := os.Open("file.txt")
if err != nil { return err }
defer file.Close()  // guaranteed to run when function exits
// ... work with file ...
```

---

## 13 - Panic & Recover

**Folder:** `13.PanicRecover/`

Go has no exceptions. Instead it uses:
- **`panic()`** — stops ordinary execution, unwinds the stack, runs deferred functions, then crashes
- **`recover()`** — regains control of a panicking goroutine. Only useful inside a deferred function.

**Without recover:**
```go
panic("something went wrong")  // program crashes
```

**With recover (in same function):**
```go
defer func() {
    if r := recover(); r != nil {
        log.Println("Recovered from:", r)
    }
}()
panic("something went wrong")
// After recover, this function exits, but any code after panic still won't run
```

**Recover in a called function:** If `panic` happens in a function called by main, and recover is in that same called function (via defer), main continues executing normally after the call. This is the standard pattern — keep panics contained.

---

## 14 - Pointers

**Folder:** `14.Pointers/`

Pointers hold memory addresses. Unlike C, Go has **no pointer arithmetic** and **automatic memory management** (garbage collection).

**Basics:**
- `&x` — address of x (pointer to x)
- `*ptr` — dereference: read or write the value at the address
- `var p *int` — declares p as a pointer to an int (nil by default)
- `p = new(int)` — allocate zero-valued int, return pointer
- `p = &x` — point to existing variable x

**Struct pointers have implicit dereferencing:**
```go
type S struct { Foo int }
ms := new(S)
(*ms).Foo = 42  // explicit dereference — works
ms.Foo = 37     // same thing — Go does it automatically
```

**Arrays vs slices:** Arrays are value types (copied entirely on assignment). To avoid copying large arrays, use a pointer: `arr := &myArray`. Slices are already reference types (they contain a pointer to the backing array).

---

## 15 - Functions

**Folder:** `15.Functions/`

Functions are first-class citizens in Go — they can be assigned to variables, passed as arguments, and returned from other functions.

**Multiple return values:**
```go
func div(a, b int) (int, error) {
    if b == 0 { return 0, fmt.Errorf("division by zero") }
    return a / b, nil
}
```

**Named return values** create local variables initialized to zero. A bare `return` returns their current values:
```go
func split(sum int) (x, y int) {
    x = sum * 4 / 9
    y = sum - x
    return  // returns x, y
}
```

**Variadic functions** accept any number of trailing arguments:
```go
func sum(nums ...int) int {
    total := 0
    for _, n := range nums { total += n }
    return total
}
sum(1, 2, 3)       // OK
sum(1, 2, 3, 4, 5) // OK
```

**Call by value vs reference:** Primitives and structs are passed by value (copied). Slices and maps are passed by reference (underlying data shared). Use `*T` to pass by reference explicitly.

**Anonymous functions** can be assigned to variables or passed directly:
```go
fn := func() { fmt.Println("hello") }
fn()
```

---

## 16 - Methods

**Folder:** `16.Methods/`

Methods are functions with a **receiver** argument that attaches them to a type. Unlike class-based languages, methods are defined **outside** the struct.

**Value receiver** (operates on a copy):
```go
func (u User) Greet() {
    fmt.Printf("Hello, I'm %s", u.Name)
}
```

**Pointer receiver** (can modify the original):
```go
func (u *User) SetName(name string) {
    u.Name = name  // modifies the original
}
```

**When to use pointer receiver:**
- To modify the receiver's fields
- To avoid copying large structs on each method call

Go automatically handles conversion between value and pointer receivers when calling methods. If you have a value and the method has a pointer receiver, Go takes the address automatically (and vice versa for pointer->value).

---

## 17 - Interfaces

**Folder:** `17.Interfaces/`

Interfaces define **behaviour** (a set of method signatures). Go's interfaces are **implicitly satisfied** — a type implements an interface simply by having the required methods. No `implements` keyword needed.

```go
type Writer interface {
    Write([]byte) (int, error)
}

type ConsoleWriter struct{}

func (cw ConsoleWriter) Write(data []byte) (int, error) {
    return fmt.Println(string(data))
}
```

**Interface composition:**
```go
type Shape interface { Area() float64 }
type Measurable interface { Perimeter() float64 }
type Geometry interface {
    Shape
    Measurable
}
```

**Empty interface `interface{}`** (alias `any` in Go 1.18+): accepts any type, since every type has zero methods.

**Type assertion:** Extract a concrete value from an interface:
```go
var i any = 42
if n, ok := i.(int); ok {
    fmt.Println(n * 2)
}
```

**Custom errors:** Any type that implements `Error() string` satisfies the `error` interface:
```go
type MyError struct{ msg string }
func (e MyError) Error() string { return e.msg }
```

---

## 18 - Goroutines

**Folder:** `18.Goroutines/`

Goroutines are lightweight threads managed by the Go runtime. They share the same address space and are multiplexed onto OS threads by Go's scheduler.

**Creating a goroutine:**
```go
go myFunction()
go func() { fmt.Println("anonymous") }()
```

**WaitGroups:** Synchronize goroutines with the main function:
```go
var wg sync.WaitGroup
wg.Add(1)
go func() {
    defer wg.Done()
    // do work
}()
wg.Wait()  // blocks until Done() is called
```

**Mutexes:** Prevent race conditions when multiple goroutines access shared data:
```go
var mu sync.Mutex
var counter int

mu.Lock()
counter++
mu.Unlock()
```

**Closure capture pitfall:** Goroutines capture variables by reference. If the variable changes before the goroutine executes, it sees the new value. Pass as argument to capture at launch time:
```go
for _, v := range items {
    go func(val string) { fmt.Println(val) }(v)  // safe
}
```

**GOMAXPROCS:** Controls how many OS threads execute goroutines simultaneously:
```go
runtime.GOMAXPROCS(20)
fmt.Println(runtime.GOMAXPROCS(-1))  // query current setting
```

---

## 19 - Channels

**Folder:** `19.Channels/`

Channels are typed conduits for sending/receiving values between goroutines.

**Unbuffered channels** (`make(chan int)`):
- Send blocks until a receiver is ready
- Receive blocks until a sender is ready
- This provides synchronization — both goroutines must be ready for the transfer

**Buffered channels** (`make(chan int, 10)`):
- Send blocks only when the buffer is full
- Receive blocks only when the buffer is empty
- Decouples sender and receiver timing

**Directional channels** restrict how a function can use a channel:
- `chan<- int` — send-only
- `<-chan int` — receive-only

**Closing channels:** `close(ch)` signals that no more values will be sent. Receivers can use a second value to check:
```go
value, ok := <-ch  // ok=false means channel is closed and empty
```

**Range over channel:**
```go
for value := range ch {
    // processes values until channel is closed
}
```

**Deadlock:** If all goroutines are blocked waiting on each other, Go detects this at runtime and crashes with "fatal error: all goroutines are asleep - deadlock!"

---

## 20 - Time

**Folder:** `20.Time/`

Go's `time` package provides date/time operations.

**Reference layout:** Go uses a unique approach to date formatting. Instead of format codes like `YYYY-MM-DD`, you provide a reference date/time: `Mon Jan 2 15:04:05 MST 2006` — which is the first 7 digits of the clock (1, 2, 3, 4, 5, 6, 7).

**Mnemonic:** `01` (month/January) `02` (day) `03`/`15` (hour, 12/24h) `04` (minute) `05` (second) `2006` (year) `-0700`/`MST` (timezone).

**Examples:**
```go
t := time.Now()
t.Format("02/01/2006")              // 13/05/2026
t.Format("Mon 02 January 2006")     // Wed 13 May 2026
t.Format("2006-01-02 15:04:05")     // ISO 8601
```

**Constructing dates:**
```go
d := time.Date(2022, time.June, 5, 0, 0, 0, 0, time.Local)
```

---

## 21 - Files

**Folder:** `21.Files/`

File I/O in Go uses the `os` and `io` packages.

**Creating/writing:**
```go
file, err := os.Create("filename.txt")
if err != nil { panic(err) }
defer file.Close()

length, err := io.WriteString(file, "content here")
```

**Reading:**
```go
data, err := os.ReadFile("filename.txt")  // returns []byte
text := string(data)  // convert bytes to string
```

**Best practice:** Defer the close immediately after opening, so you never forget:
```go
file, err := os.Create("file.txt")
if err != nil { return }
defer file.Close()
// ... work with file ...
```

---

## 22 - Math

**Folder:** `22.Math/`

The `math` package provides mathematical constants and functions.

**Rounding:**
- `math.Round(x)` — nearest integer, ties round away from zero
- `math.Floor(x)` — round down
- `math.Ceil(x)` — round up

**Other functions:** `Sqrt()`, `Log()`, `Sin()`, `Cos()`, `Pow()`, `Exp()`

**Formatting:**
- `%g` — compact representation, rounds
- `%f` — decimal notation
- `%.2f` — 2 decimal places
- `Printf` uses these verbs for formatted output

**Random numbers (`math/rand`):**
```go
rand.Seed(time.Now().UnixNano())  // seed for different values each run
n := rand.Intn(6)  // random int in [0, 6)
```

---

## 23 - Web Requests

**Folder:** `23.WebRequests/`

Making HTTP requests and working with URLs.

**GET request:**
```go
resp, err := http.Get("https://api.example.com/data")
if err != nil { panic(err) }
defer resp.Body.Close()

body, err := io.ReadAll(resp.Body)
fmt.Println(string(body))
```

**Always close the response body** — Go does not automatically close it, and failing to do so leaks resources.

**URL parsing (`net/url`):**
```go
u, _ := url.Parse("https://example.com:8080/path?key=value")
fmt.Println(u.Scheme)     // https
fmt.Println(u.Host)       // example.com:8080
fmt.Println(u.Port())     // 8080
fmt.Println(u.RawQuery)   // key=value
fmt.Println(u.Query())    // map[key:[value]]
```

**Constructing URLs:**
```go
u := &url.URL{
    Scheme:   "https",
    Host:     "example.com",
    Path:     "/api",
    RawQuery: "page=1",
}
fmt.Println(u.String())  // https://example.com/api?page=1
```

---

## 24 - JSON

**Folder:** `24.Json/`

Encoding and decoding JSON using Go's standard library `encoding/json`.

**Struct tags** control JSON field names and behavior:
- `json:"fieldname"` — custom field name in JSON
- `json:"-"` — exclude field entirely
- `json:"field,omitempty"` — omit field if zero value

**Encoding (struct → JSON):**
```go
type Course struct {
    Name  string   `json:"coursename"`
    Price int      `json:"price"`
    Tags  []string `json:"tags,omitempty"`
}
jsonData, _ := json.Marshal(courses)
prettyJSON, _ := json.MarshalIndent(courses, "", "\t")
```

**Decoding (JSON → struct):**
```go
var course Course
json.Unmarshal(jsonBytes, &course)

// Or decode into a generic map:
var data map[string]interface{}
json.Unmarshal(jsonBytes, &data)
```

**Validation:** `json.Valid(data)` returns true if the byte slice is valid JSON.

---

## 25 - Context

**Folder:** `25.Context/`

Context provides a standard way to carry deadlines, cancellation signals, and request-scoped values across API boundaries and goroutines.

**Timeout context:**
```go
ctx, cancel := context.WithTimeout(context.Background(), 100*time.Millisecond)
defer cancel()

req, _ := http.NewRequestWithContext(ctx, "GET", url, nil)
resp, err := http.DefaultClient.Do(req)
```

If the operation takes longer than the timeout, the context cancels the request automatically, and `err` will contain a deadline-exceeded error. This prevents hanging connections and lets you implement graceful degradation.

**Context hierarchy:** `context.Background()` is the root. `context.WithTimeout`, `context.WithCancel`, and `context.WithValue` create child contexts that propagate cancellation to all derived contexts.

---

## 26 - REST APIs (gorilla/mux)

**Folder:** `26.APIs/`

Building a full CRUD REST API using the `gorilla/mux` router.

**Folder structure:**
```
26.APIs/
├── controllers/   — HTTP handler functions
├── data/          — in-memory data store
├── models/        — data structs
└── main.go        — router setup and server start
```

**Routing with gorilla/mux:**
```go
r := mux.NewRouter()
r.HandleFunc("/courses", GetAllCourses).Methods("GET")
r.HandleFunc("/course/{id}", GetCourseById).Methods("GET")
r.HandleFunc("/course", AddNewCourse).Methods("POST")
r.HandleFunc("/course/{id}", UpdateCourse).Methods("PUT")
r.HandleFunc("/course/{id}", DeleteCourse).Methods("DELETE")
http.ListenAndServe(":4000", r)
```

**Path parameters** are extracted with `mux.Vars(request)["id"]`.

**CRUD operations** were implemented against an in-memory data store, showing the full request-response cycle.

---

## 27 - Generics

**Folder:** `27.Generics/`

Generics (added in Go 1.18) allow writing type-safe, reusable code without sacrificing performance.

**Type parameters:**
```go
func Add[T int8 | int16 | int32 | int | float32 | float64](a, b T) T {
    return a + b
}
Add[int](3, 5)    // explicit type
Add(3.2, 4.1)     // type inference
```

**Type constraint interfaces:**
```go
type Number interface {
    int8 | int16 | int32 | int | float32 | float64
}
func Add[T Number](a, b T) T { return a + b }
```

**Generic structs:**
```go
type User[T Number] struct {
    Name string
    Age  T
}
u := User[int]{Name: "Jack", Age: 20}
```

**`comparable` constraint:** Predeclared constraint for types that support `==` and `!=`.

**Use cases:** Generic data structures (stacks, trees, graphs), mathematical functions, utility libraries.

---

## 28 - Gin Framework

**Folder:** `28.Gin/`

Gin is a popular high-performance HTTP web framework.

**Setup:**
```go
r := gin.Default()  // creates router with Logger and Recovery middleware
r.GET("/", func(c *gin.Context) {
    c.JSON(200, gin.H{"message": "pong"})
})
r.Run()  // listens on :8080
```

**gin.Context** provides:
- `c.JSON(code, obj)` — send JSON response
- `c.Param("name")` — URL path parameters
- `c.Query("key")` — query string parameters
- `c.PostForm("key")` — form data
- `c.BindJSON(&obj)` — parse JSON request body

**gin.H** is a shortcut for `map[string]interface{}`.

Install: `go get -v github.com/gin-gonic/gin`

---

## 29 - Fyne UI (Desktop GUI)

**Folder:** `29.FyneUI/`

Fyne is a cross-platform GUI toolkit for Go.

```go
a := app.New()                    // create application
w := a.NewWindow("Hello World")   // create window
w.SetContent(widget.NewLabel("Hello World!"))
w.ShowAndRun()                    // display window
```

**Concepts:**
- `app.New()` — initialize the application
- `widget.NewLabel()`, `widget.NewButton()`, `widget.NewEntry()` — UI elements
- `vbox.NewVBox()`, `container.NewHBox()` — layout containers
- `w.ShowAndRun()` — enters the event loop

Fyne is self-contained (no system GUI toolkit dependencies) and compiles to a native binary.

---

## 30 - Ebitengine (Game Development)

**Folder:** `30.Ebiten/`

Ebitengine is a simple 2D game engine for Go.

**Core interface (must implement):**
```go
type Game interface {
    Update() error         // called every frame — update game logic
    Draw(screen *Image)    // called every frame — render
    Layout(w, h int) (int, int)  // screen size
}
```

**Game loop:**
```go
ebiten.SetWindowSize(640, 480)
ebiten.SetWindowTitle("Snake Game")
ebiten.RunGame(&game)
```

The script sets up a `SnakeGame` skeleton structure that implements the `Game` interface — a starting point for building a Snake game with movement, collision, and scoring logic.

---

## 31 - Reflection

**Folder:** `31.Reflection/`

Reflection lets you inspect and manipulate types at runtime using the `reflect` package.

**Basic usage:**
```go
t := reflect.TypeOf(x)     // get type information
v := reflect.ValueOf(x)    // get value information
```

**Iterating struct fields:**
```go
for i := 0; i < v.NumField(); i++ {
    field := v.Type().Field(i)
    value := v.Field(i)
    name := field.Name
    kind := value.Kind()
    tag := field.Tag.Get("validate")
}
```

**Practical example — validation framework:**
The script implements a generic struct validator using custom `validate` tags:
```go
type User struct {
    Name  string `validate:"required,min=2"`
    Email string `validate:"required,email"`
    Age   int    `validate:"min=0,max=120"`
}
```

The `validate()` function uses reflection to read tags, check field values, and return errors for invalid data. This demonstrates how libraries like `go-playground/validator` work internally.

---

## 32 - GORM (ORM)

**Folder:** `32.GORM/`

GORM is a full-featured ORM for Go.

**Model definition:**
```go
type User struct {
    gorm.Model           // embeds ID, CreatedAt, UpdatedAt, DeletedAt
    ID   int    `gorm:"primaryKey"`
    Name string `gorm:"size:255"`
}
```

**Database connection (PostgreSQL):**
```go
dsn := "host=localhost user=postgres password=pass dbname=postgres port=5432 sslmode=disable"
db, err := gorm.Open(postgres.Open(dsn), &gorm.Config{})
```

**CRUD operations:**
- `db.AutoMigrate(&User{})` — create/update tables
- `db.Create(&user)` — insert
- `db.Where("name LIKE ?", "J%").Find(&users)` — query with condition
- `db.Where("id = ?", 2).First(&user)` — get single record
- `db.Save(&user)` — update all fields
- `db.Delete(&user)` — soft delete (sets `deleted_at`)
- `db.Unscoped().Delete(&user)` — hard delete

**Logger:** GORM has a configurable logger for SQL query logging and slow-query thresholds.

---

## 99 - Test / Misc

**Folder:** `99.Test/`

A scratchpad folder for miscellaneous experiments. Currently demonstrates using `reflect.TypeOf` to print the type of a variable.

---

## Quick Reference

| Command | Description |
|---------|-------------|
| `go run main.go` | Run a Go program directly |
| `go build` | Compile into a binary |
| `go mod init <name>` | Initialize a new module |
| `go get <package>` | Install a 3rd party package |
| `go run -race main.go` | Run with race detector |
| `GOOS="linux" go build` | Cross-compile for Linux |
| `GOOS="windows" go build` | Cross-compile for Windows |
| `GOOS="darwin" go build` | Cross-compile for macOS |
| `go install` | Install binary to `$GOPATH/bin` |
| `go test ./...` | Run all tests |
| `go fmt ./...` | Format all Go code |
| `go vet ./...` | Analyze code for suspicious constructs |

## Project Structure

```
project/
├── 01.HelloWorld/   ──>  main.go
├── 02.Variables/    ──>  main.go
├── ...
├── 32.GORM/         ──>  main.go
└── 99.Test/         ──>  main.go
```

Each folder contains its own `go.mod` and `main.go`. No shared dependencies between modules — each is self-contained and can be run independently.
