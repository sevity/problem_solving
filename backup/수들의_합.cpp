#include <bits/stdc++.h>
using namespace std;
int main() {
    long long S;scanf("%lld", &S);
    int i=1;
    for(;;i++){
        S-=i;
        if(S==0) break;
        if(S<0) {i--;break;}
    }
    printf("%d", i);

    return 0;
}