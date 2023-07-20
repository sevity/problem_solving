#include <bits/stdc++.h>
using namespace std;
int main(){
    int N;scanf("%d", &N);
    while(N--){
        int C;scanf("%d", &C);
        int cnt;
        cnt=0;while(C>=25) C-=25,cnt++;
        printf("%d ", cnt);
        cnt=0;while(C>=10) C-=10,cnt++;
        printf("%d ", cnt);
        cnt=0;while(C>=5) C-=5,cnt++;
        printf("%d ", cnt);
        cnt=0;while(C>=1) C-=1,cnt++;
        printf("%d\n", cnt);
    }
    return 0;
}
