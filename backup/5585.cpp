#include <bits/stdc++.h>
using namespace std;
int main(){
    int C;scanf("%d", &C);
    C = 1000 - C;
    int cnt;
    cnt=0;
    while(C>=500) C-=500,cnt++;
    while(C>=100) C-=100,cnt++;
    while(C>=50) C-=50,cnt++;
    while(C>=10) C-=10,cnt++;
    while(C>=5) C-=5,cnt++;
    while(C>=1) C-=1,cnt++;
    printf("%d\n", cnt);
    return 0;
}
