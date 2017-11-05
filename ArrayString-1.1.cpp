/* If there are Unique Characters in a string*/
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
int main()
{
	int t;
	cin>>t;
	while(t--){
		string s;
		cin>>s;
		int x=0,i=0;
		for(;i<s.length();i++){
			if(x & 1<<(s[i]-'a')){
				cout<<"No"<<endl;
				break;
			}
			x = x | 1<<(s[i]-'a');
		}
		if(i==s.length())
		cout<<"Yes"<<endl;
	}
	return 0;
}
