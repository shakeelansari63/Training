#include<iostream>
// inplist is input list imported from inputlist.h
// listlen is length of list
#include "common.h"
using namespace std;

void quick_sort_func(int *lst, int start, int end, int pivot);
// Main Function
int main ()
{
    int i, j;
    // Output the Actual List
    display_list("Input list ...");

    // Quick Sort Logic Starts Here
    int pivot = 0; // Any Pivot Element
    int starting = 0; // Start Position of traversing
    int ending = listlen - 1; // End Position of traversing

    // Call Quick Sort Function with initial Start and End Positions
    quick_sort_func(inplist, starting, ending, pivot);

    // Output Sorted List
    display_list("\nSorted Element List ...");
    // Return Statement
    return 0;
}

// This is backbone of Quick Sort. It partitions the List and exchange the positions.
// Hence Quick sort is also called Partition exchange sort
void quick_sort_func(int *lst, int start, int end, int pivot){ 
    int temp;
    int lower_bound = start;
    int upper_bound = end;
    while(true){
        // Traverse Start to right till you find element greater than pivot
        while(lst[start] <= lst[pivot]){
            start++;
        }

        // Traverse End to left till you find element less than pivot
        while(lst[end] > lst[pivot]){
            end--;
        }
        
        // Swap the Elements at Start and End if Start < End else swap Pivot and End
        if(start >= end){
            // This exchange the values between start and end positions
            temp = lst[pivot];
            lst[pivot] = lst[end];
            lst[end] = temp;
            break;
        } else {
            // This exchange the position of end and pivot, bringing Pivot element on end position.
            temp = lst[start];
            lst[start] = lst[end];
            lst[end] = temp;
        }
    }

    // Recursive Call on left side partition of pivot element if 
    if(end > lower_bound){
        quick_sort_func(lst, lower_bound, end - 1, lower_bound);
    }

    // Recursive Call on right side partition of pivot element
    if(end < upper_bound){
        quick_sort_func(lst, end + 1, upper_bound, end + 1);
    }
}