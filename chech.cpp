#include <iostream>
using namespace std;

int main(){
    static int a=5;
    cout<<a--;
    if(a)
        main();
    return 0;
}
