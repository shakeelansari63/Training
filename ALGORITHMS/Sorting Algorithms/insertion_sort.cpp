#include<iostream>
// inplist is input list imported from inputlist.h
// listlen is length of list
#include "common.h"
using namespace std;

// Main Function
int main ()
{
    int i, j,temp;
    // Output the Actual List
    display_list("Input list ...");

    // Insertion Sort Loops
    // Unsorted Sublist loop from item 1
    for(i = 1; i<listlen; i++) {
        temp = inplist[i]; 

        // Right Shift the elements of Sorted sublist until first item 
        // of unsorted sublist is less than items in sorted sublist.
        for(j = i-1; j >= 0 && inplist[j] > temp; j--)
        {
            inplist[j+1] = inplist[j];
        }
        // Insert temp value to right of current location since above for loop 
        // would have decremented the value
        inplist[j+1] = temp;
    }

    // Output Sorted List
    display_list("\nSorted Element List ...");
    // Return Statement
    return 0;
}