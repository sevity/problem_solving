#include <bits/stdc++.h>
using namespace std;
int m1[101][101], m2[101][101];
int main(){
    int N,M;scanf("%d%d", &N, &M);
    for(int y=0;y<N;y++)for(int x=0;x<M;x++)scanf("%d", &m1[y][x]);
    for(int y=0;y<N;y++)for(int x=0;x<M;x++)scanf("%d", &m2[y][x]);
    for(int y=0;y<N;y++)for(int x=0;x<M;x++) m1[y][x] += m2[y][x];
    for(int y=0;y<N;y++){
        for(int x=0;x<M;x++)printf("%d ", m1[y][x]);
        printf("\n");
    }
    return 0;
}
