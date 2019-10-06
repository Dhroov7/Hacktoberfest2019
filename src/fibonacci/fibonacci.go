// show fibonacci series to 50 terms.
package main

import "fmt"

func fibonacci(c, quit chan int) {   // This function takes in two int channels, 'c' and 'quit'
    x, y := 0, 1                     // defines x and y
    for {                            // run until something stops it
        select {                     //
        case c <- x:                 //
            x, y = y, x+y            // fibonacci calculation
        case <-quit:                 // if the function recieves anything from the 'quit' channel:
            fmt.Println("quit")      // print "quit"
            return                   // and then end the function
        }                            // these are all possible cases
    }                                // done with "for"
}                                    // done with "fibonacci"

func main() {                        // the main function
    c := make(chan int)              // c is a new int channel
    quit := make(chan int)           // quit is a new int channel
    go func() {                      // run this function in the background:
        for i := 0; i < 50; i++ {    // count to 10, storing the values in i
            fmt.Println(<-c)         // and for each number, print the output of c
        }                            // done counting
        quit <- 0                    // after it is done counting to 10, send 0 on the quit channel
    }()                              // end of go'd function
    fibonacci(c, quit)               // call fibonacci with the newly made c and quit channels
}