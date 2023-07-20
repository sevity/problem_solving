#include <bits/stdc++.h>
using namespace std;
int m1[101][101];
int main(){
    for(int y=0;y<9;y++)for(int x=0;x<9;x++)scanf("%d", &m1[y][x]);
    int max_value = -1;
    int my, mx;
    for(int y=0;y<9;y++)for(int x=0;x<9;x++){
        if(m1[y][x]>max_value){
            max_value = m1[y][x];
            my=y, mx=x;
        }
    }
    printf("%d\n%d %d\n", max_value, my+1, mx+1);
    return 0;
}
