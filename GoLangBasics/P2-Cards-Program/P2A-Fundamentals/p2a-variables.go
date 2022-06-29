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

	/*

		Type Conversion
		---------------

			If the data need to be converted from one type to another

				<<output type>> ( <<input type>> )

				eg:
					[]byte("Hi !!")

		Byte Slicing
		------------

		Sometimes we need to convert the data to Byte[] inorder to store the data
		We use Type conversion to convert the data to byte type

	*/
	str := "Hi !! How are you"
	fmt.Println("Byte Slicing ", []byte(str))
	/*

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
	Byte Slicing  [72 105 32 33 33 32 72 111 119 32 97 114 101 32 121 111 117]

*/
