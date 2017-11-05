#include <bits/stdc++.h>
using namespace std;

void replaceSpaces(char str[], int len){
    
    int spaceCount = 0, newLen;
    
    for(int i=0; i<len; ++i){
        if(str[i]==' ')
            spaceCount++;
    }

    newLen = len + 2*spaceCount;

    str[newLen] = '\0';
    newLen--;
    // cout<<str<<endl;
    for(int i = len-1; i>=0; --i){
        if(str[i]!=' '){
            str[newLen--] = str[i];
        } 
        else{
            str[newLen--] = '0';
            str[newLen--] = '2';
            str[newLen--] = '%';
        }
    }
    
    // return str;
}

int main(){
    string s;
    getline(cin, s);
    char str[s.length()+1];
    strcpy (str, s.c_str());
    cout<<str<<endl;
    replaceSpaces(str, sizeof(str)/sizeof(char));
    cout<<str<<endl;
    return 0;
}