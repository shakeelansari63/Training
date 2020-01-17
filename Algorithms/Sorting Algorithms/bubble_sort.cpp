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

    // Bubble Sort Loop going multiple passes
    for(i = 0; i<listlen; i++) {
        for(j = i+1; j<listlen; j++)
        {
            if(inplist[j] < inplist[i]) {
                temp = inplist[i];
                inplist[i] = inplist[j];
                inplist[j] = temp;
            }
        }
    }

    // Output Sorted List
    display_list("\nSorted Element List ...");
    // Return Statement
    return 0;
}