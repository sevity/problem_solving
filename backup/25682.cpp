#include <bits/stdc++.h>
using namespace std;
char arr[2001][2001];
int sum[2][2001][2001];
int main() {
    int N, M, K; scanf("%d%d%d\n", &N, &M, &K); 
    for(int y=0;y<N;y++)for(int x=0;x<M;x++) scanf("\n%c", &arr[y][x]);
    for(int y=0;y<N;y++){
        int psum[2] = {};
        for(int x=0;x<M;x++) {
            int n = (x+y)%2;  // 0이면 black자리
            if( (n==1 && arr[y][x]=='B') ||
                (n==0 && arr[y][x]=='W') )  // color mismatch
                    psum[0]++;
            if( (n==0 && arr[y][x]=='B') ||
                (n==1 && arr[y][x]=='W') )  // color mismatch
                    psum[1]++;
            sum[0][y][x] = (y>0?sum[0][y-1][x]:0) + psum[0];
            sum[1][y][x] = (y>0?sum[1][y-1][x]:0) + psum[1];
        }
    }
    int ans = 2000*2000+1;
    for(int y=0;y<N;y++){
        if(y+K-1>N-1) continue;
        for(int x=0;x<M;x++) {
            if(x+K-1>M-1) continue;
            for(int j=0;j<2;j++)
                ans = min(ans,
                    sum[j][y+K-1][x+K-1]
                        -(x>0?sum[j][y+K-1][x-1]:0)
                        -(y>0?sum[j][y-1][x+K-1]:0)
                        +(x>0&&y>0?sum[j][y-1][x-1]:0));
        }
    }
    printf("%d\n", ans);
    return 0;
}

