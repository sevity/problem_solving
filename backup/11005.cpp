#include <bits/stdc++.h>
using namespace std;
char convert(int c){
    if(c<10) return '0'+c;
    return 'A' + c-10;
}
int main(){
    int N;
    int B;
    scanf("%d %d", &N, &B);
    string ans;
    while(N){
        ans += convert(N%B);
        N/=B;
    }
    reverse(ans.begin(), ans.end());
    printf("%s\n", ans.c_str());
    return 0;
}
