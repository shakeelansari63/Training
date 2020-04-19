#include<iostream>
// inplist is input list imported from inputlist.h
// listlen is length of list
#include "common.h"
using namespace std;

void merge_sort_func(int *lst, int starting, int ending);
// Main Function
int main ()
{
    // Output the Actual List
    display_list("Input list ...");

    // Merge Sort Logic Starts Here
    int starting = 0;
    int ending = listlen - 1;
    merge_sort_func(inplist, starting, ending);

    // Output Sorted List
    display_list("\nSorted Element List ...");
    // Return Statement
    return 0;
}

// Merge Sort Function for dividing and merging the List
void merge_sort_func(int *lst, int start, int end){
    // This if needed to kill recursion. 
    // Call merge sort function recursively for dividing the array till we have 1 element in sublist
    if(start < end){
        int mid = (start + end) / 2;
        
        // Divide the left of array from mid
        merge_sort_func(lst, start, mid);

        // Divide the right of raay from mid
        merge_sort_func(lst, mid + 1, end);

        // After all Recursive divide calls are completed, we merge the lists
        // For this, we extart left and right list seperately and merge them back to original list
        // Size of Left Sublist
        int size_left_sublist = mid - start + 1;

        // Size of Right Sublist
        int size_right_sublist = end - mid;

        // Define 2 sublists as per the size 
        int left_sublist[size_left_sublist], right_sublist[size_right_sublist];

        // Populate the Left Sublist
        for(int i = 0; i < size_left_sublist; i++){
            left_sublist[i] = lst[start + i];
        }

        // Populate the Right Sublist
        for(int i = 0; i< size_right_sublist; i++){
            right_sublist[i] = lst[mid + 1 + i];
        }

        // We need 3 pointers to point to 3 lists we have left (sublist), right (sublist) & actual list
        int l_ptr = 0, r_ptr = 0, lst_ptr = start;

        // Merging begins
        while(l_ptr < size_left_sublist or r_ptr < size_right_sublist){
            // Chekcing is both Sublists have a value for comparision
            if(l_ptr < size_left_sublist && r_ptr < size_right_sublist){
                // Compare the left sublist and right sublist values
                // and put lesser value in actual list
                if(left_sublist[l_ptr] < right_sublist[r_ptr]){
                    lst[lst_ptr] = left_sublist[l_ptr];
                    l_ptr++;
                } else {
                    lst[lst_ptr] = right_sublist[r_ptr];
                    r_ptr++;
                }
            } 
            // Checking if Left Sublist is exhausted
            else if(l_ptr == size_left_sublist){
                // Copy Right Sublist Item in actual List
                lst[lst_ptr] = right_sublist[r_ptr];
                r_ptr++;
            } 
            // Checking if Right Sublist is exhausted
            else if(r_ptr == size_right_sublist){
                // Copy Left Sublist Item in actual List
                lst[lst_ptr] = left_sublist[l_ptr];
                l_ptr++;
            }
            // Increment List pointer to move forward
            lst_ptr ++;
        }
    }
}