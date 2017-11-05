/*reverse a C-Style String*/
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

void reverseCStyle(char *str)
{
    char *e = str, tmp;

    if(str){
        while(*e){
            ++e;
        }
        --e;
        while(str<e){
            cout<<*str<<" "<<*e<<endl;
            tmp = *str;
            *str++ = *e;
            *e-- = tmp;
            cout<<*str<<" "<<*e<<endl;
        }
    }
}

int main()
{
    char str[] = "shivam";//  OR {'s','h','i','v','a','m','\0'}; Same thing //
    int n = sizeof(str)/sizeof(char);
//    cout<<n<<endl;
    reverseCStyle(str);
    cout<<str<<endl;
	return 0;
}
