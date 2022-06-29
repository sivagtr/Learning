package main

import "fmt"

func main() {
	cards := newDeck()

	fmt.Println("-------------------------Printing the DEAL-------------------------")
	cards.print()

	hand, remain := deal(cards, 5)

	fmt.Println("------------------------- Printing the HAND -------------------------")
	hand.print()

	fmt.Println("------------------------- Printing the REMAIN -------------------------")
	remain.print()

	fmt.Println("------------------------- Converting to String -------------------------")
	fmt.Println(hand.toString())
}
