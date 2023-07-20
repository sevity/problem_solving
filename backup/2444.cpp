#include <bits/stdc++.h>
using namespace std;
int main(){
    int N;scanf("%d", &N);
    for(int i=1;i<=N;i++){
        int star_cnt = 1 + 2*(i-1);
        int indent = N-i;
        for(int j=0;j<indent;j++) printf(" ");
        for(int j=0;j<star_cnt;j++) printf("*");
        printf("\n");
    }
    for(int i=N-1;i>=1;i--){
        int star_cnt = 1 + 2*(i-1);
        int indent = N-i;
        for(int j=0;j<indent;j++) printf(" ");
        for(int j=0;j<star_cnt;j++) printf("*");
        printf("\n");
    }
    return 0;
}
