#include <bits/stdc++.h>
using namespace std;
int convert(char c){
    if(c<='9') return c - '0';
    return c-'A' + 10;
}
int main(){
    char N[100];
    int B;
    int ans = 0;
    int digi = 1;
    scanf("%s %d", N, &B);
    for(int i=0;i<strlen(N);i++){
        char last_digit = N[strlen(N)-1-i];
        ans += convert(last_digit) * digi;
        digi*=B;
    }
    printf("%d\n", ans);

    return 0;
}
