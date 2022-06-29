package main

import "fmt"

func main() {
	card := getCard()
	fmt.Println("Card Data : ", card)

	counter := 1
	incCounter := incrementCounter(counter)
	fmt.Println("Incremented Counter ", incCounter)

	/*

		Multi-Function Return Type Capture
		----------------------------------

		Multi Function return type is captured with valiables with ,

			<<var1>>, <<var2>> := multiFunc(<<args>>)

			func multiFunc(<<args>>) (type, type){
				return type, type
			}

	*/

	heading, pageNo := getMultiFuncData("Heading is", 1)
	fmt.Println(heading)
	fmt.Println(pageNo)
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

	Multi-Return Function and Slicing
	---------------------------------

	We can return multiple values from the function by () after return type

*/

func getMultiFuncData(heading string, pageNo int) (string, int) {
	return heading + " Hello World", pageNo + 10
}

/*

Output:
-------

Card Data :  Data Here..!!!
Incremented Counter  2

*/
