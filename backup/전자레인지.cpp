#include <bits/stdc++.h>
using namespace std;
int main() {
    int T;cin>>T;
    int a=0,b=0,c=0;
    a = T/(5*60), T%=5*60;
    b = T/60,T%=60;
    c = T/10,T%=10;
    if(T) puts("-1");
    else printf("%d %d %d", a, b, c);
    return 0;
}
