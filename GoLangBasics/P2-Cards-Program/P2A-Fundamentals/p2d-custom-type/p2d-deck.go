package main

import "fmt"

/*

Custom Type Declaration
-----------------------

type <<name>> <<type>>

*/
type deck []string

/*
Receiver function -- (d deck)
-----------------------------
Here we declare with 1 letter / 2 letter or 3 letter word for receiver funciton
The same will be accessed.

*/
func (d deck) print() {
	for i, val := range d {
		fmt.Println(i, val)
	}
}
