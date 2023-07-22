#include <bits/stdc++.h>
using namespace std;
int main() {
    int A, B, C, D; scanf("%d%d%d%d", &A, &B, &C, &D);
    while(D--){
        if(++C>=60) C=0,B++;
        if(B>=60) B=0, A++;
        if(A>=24) A=B=C=0;
    }
    printf("%d %d %d", A, B, C);
    return 0;
}
