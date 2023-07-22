#include <bits/stdc++.h>
using namespace std;
int dfs(int N, int M){
    if(N==1 && M==1) return 0;
    if(N>M) return 1 + dfs(N/2,M) + dfs(N-N/2,M);
    else return 1 + dfs(N,M/2) + dfs(N, M-M/2);
}
int main() {
    int N,M;scanf("%d%d", &N, &M);
    printf("%d\n", dfs(N, M));
    return 0;
}
