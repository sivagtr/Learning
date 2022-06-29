package main

// To Run Code
// go run p2d-main.go p2d-deck.go

func main() {
	cards := deck{"Hello", "World", getName()}
	cards = append(cards, "Hehe")

	cards.print()
}

func getName() string {
	return "Test !!!!"
}
