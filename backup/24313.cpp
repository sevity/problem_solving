#include <bits/stdc++.h>
using namespace std;
int main() {
    int a1,a0;scanf("%d%d", &a1,&a0);
    int c,n0;scanf("%d%d", &c, &n0);
    auto f = [&](int n) {
        return a1*n+a0;    
    };
    for(int i=0;i<10000;i++){
        if(f(n0+i)>c*(n0+i)) {puts("0");return 0;}
    }
    puts("1");
    return 0;
}
