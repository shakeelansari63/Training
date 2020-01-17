#include<iostream>
#include<string>

const int listlen = 10;
int inplist[listlen] = {10,2,0,14,43,25,18,1,5,45};

using namespace std;

void display_list(string message){
    int i;
    cout << message << endl;
    for(i = 0; i<listlen; i++) {
        cout <<inplist[i]<<"\t";
    }
    // New Line
    cout<<endl;
}