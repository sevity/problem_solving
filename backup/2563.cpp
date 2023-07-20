#include <bits/stdc++.h>
using namespace std;
int canvas[101][101];
int main(){
    int N;scanf("%d", &N);
    while(N--){
        int sx,sy;scanf("%d%d", &sx,&sy);
        for(int y=0;y<10;y++)for(int x=0;x<10;x++) canvas[y+sy][x+sx]=1;
    }

    int sum = 0;
    for(int y=1;y<=100;y++)for(int x=1;x<=100;x++){
        if(canvas[y][x]) sum++;
    }
    printf("%d\n", sum);
    return 0;
}
