package main

import "fmt"

func main() {
	card := getCard()
	fmt.Println("Card Data : ", card)

	counter := 1
	incCounter := incrementCounter(counter)
	fmt.Println("Incremented Counter ", incCounter)
}

// Return type need to declared after the function name
func getCard() string {
	return "Data Here..!!!"
}

// Increment and Return the counter
func incrementCounter(counter int) int {
	return counter + 1
}

/*

Output:
-------

Card Data :  Data Here..!!!
Incremented Counter  2

*/
