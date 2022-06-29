package main

import "fmt"

func main() {
	/*

		Here Arrays are homogenious -- Only one type is allowed
			Fixed Size is called Array
			Variable Size is called Slice


		slice [inclusive: exclude]	-- For split
		eg:
			vals := []int{1,2,3,4,5}
			vals[0:3] -- {1,2,3} // Index Starts at 0
			vals[3:4] -- {4}

			vals[:2] -- {1,2}
			vals[3:] -- {4,5}

	*/
	strs := []string{"Test ", getString()}
	strs = append(strs, "World")

	/*

		For Loop Syntax
		----------------

		for <<index>>, <<variable>> := range <<Array/Slice>> {

		}

		if the index is not used, use "_".
		Go Complier will ignore it.

	*/

	for i, str := range strs {
		fmt.Println(i, str)
	}

	first, second := getSlice(strs, 2)
	fmt.Println("First Slice -- ")
	// _ used since the index is not used for printing
	for _, f := range first {
		fmt.Println(f)
	}
	fmt.Println("Second Slice -- ")
	for _, s := range second {
		fmt.Println(s)
	}
}

func getString() string {
	return "Hello "
}

func getSlice(slice []string, i int) ([]string, []string) {
	return slice[:i], slice[i:]
}
