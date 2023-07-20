#include <bits/stdc++.h>
int A[101];
int main(void){
    int N,M;scanf("%d%d", &N, &M);
    while(M--){
        int i,j,k;scanf("%d%d%d", &i, &j, &k);
        for(int z=i;z<=j;z++){
            A[z-1] = k;
        }
    }
    for(int i=0;i<N;i++) printf("%d ", A[i]);
    return 0;
}
