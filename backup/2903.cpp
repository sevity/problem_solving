#include <bits/stdc++.h>
using namespace std;
int main(){
    int N;scanf("%d", &N);
    int L[16] = {};
    L[0] = 2;
    for(int i=1;i<=15;i++) L[i] = 2*L[i-1]-1;
    printf("%d\n", L[N]*L[N]);
    return 0;
}
