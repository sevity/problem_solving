#include <bits/stdc++.h>
int A[101];
int main(void){
    int N,M;scanf("%d%d", &N, &M);
    for(int i=0;i<N;i++) A[i] = i+1;
    while(M--){
        int i,j;scanf("%d%d", &i, &j);
        std::swap(A[i-1], A[j-1]);
    }
    for(int i=0;i<N;i++) printf("%d ", A[i]);
    return 0;
}
