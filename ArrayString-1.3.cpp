/* Removing Duplicates without using any Extra Buffer */
#include<iostream>
#include<climits>
#include<cstdio>
#include<cmath>
#include<algorithm>
#include<vector>
#include<string>
#include<list>

#define FORSC(A,n1,n2) for(int i=n1;i<n2;i++){cin>>A[i];}
#define FOROUT(A,n1,n2) for(int i=n1;i<n2;i++){cout<<A[i]<<" ";}

using namespace std;

void removeDups(string &s){
    int tail=1;
    for(int i=1;i<s.length();++i){
        int j;
        for(j=0;j<tail;j++){
            if(s[i]==s[j]){
                break;
            }
        }
        if(j==tail){
            s[tail] = s[i];
            ++tail;
        }
    }
    s.erase(s.begin()+tail,s.end());
}

int main()
{
    string s;
    cin>>s;
    removeDups(s);
    cout<<s<<endl;
	return 0;
}
