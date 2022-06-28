package main

import "fmt"

func main() {
	// Declaration of variable with type
	var card string = "Declarative String : Hello Word"
	fmt.Println(card)

	// Imparative Declaration of variable

	/**
	* Creation of new variable
	* 	This requires :=
	 */
	msg := "Imparative New Variable : Hello"
	fmt.Println(msg)

	// Use of = for assigning data to variable
	msg = "Assignment : Test"
	fmt.Println(msg)

	counter := 1
	fmt.Println("Int variable : ", counter)
	/**

	Some of the types
	-----------------
	string
	int
	float64
	bool

	*/
}

/*

Output:
-------

Declarative String : Hello Word
Imparative New Variable : Hello
Assignment : Test
Int variable :  1

*/
