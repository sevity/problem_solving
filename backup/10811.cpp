#include <bits/stdc++.h>
int A[101], B[101];
int main(void){
    int N,M;scanf("%d%d", &N, &M);
    for(int i=0;i<N;i++) A[i] = i+1;
    while(M--){
        int i,j;scanf("%d%d", &i, &j);
        for(int z=i;z<=j;z++){
            B[j-1-(z-i)] = A[z-1];
        }
        for(int z=i;z<=j;z++)A[z-1]=B[z-1];
    }
    for(int i=0;i<N;i++) printf("%d ", A[i]);
    return 0;
}
