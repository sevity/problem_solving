#include <bits/stdc++.h>
using namespace std;
int main(){
    int N, K;scanf("%d%d", &N, &K);
    for(int i=1;i<=N;i++){
        if(N%i==0) K--;
        if(K==0) {printf("%d\n", i);return 0;}
    }
    printf("0\n");
    return 0;
}