package main

import (
	"fmt"
	"strings"
)

type deck []string

func newDeck() deck {
	cards := deck{}

	cardSuits := []string{"Spades", "Ace", "Diamond", "Heart"}
	cardType := []string{"One", "Two", "Three", "Four"}

	/*

		If the variable is not used, we replace with "_"
		Go compiler will ignore it.
		@Ref: p2c-looping-slice.go
	*/
	for _, suit := range cardSuits {
		for _, t := range cardType {
			cards = append(cards, suit+" of "+t)
		}
	}

	return cards
}

func (d deck) print() {
	for _, t := range d {
		fmt.Println(t)
	}
}

// Multi-Return @Ref: p2b-func-return.go
func deal(d deck, handSize int) (deck, deck) {
	// Slicing -- @Ref: p2c-looping-slice.go
	return d[:handSize], d[handSize:]
}

func (d deck) toString() string {
	// []string(d) -- Type Conversion  -- @Ref: p2a-variables.go
	return strings.Join([]string(d), ",")
}
