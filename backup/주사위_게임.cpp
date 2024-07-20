#include <bits/stdc++.h>
using namespace std;
int main() {
    int a = 100, b = 100;
    int n;cin>>n;while(n--){
        int j1,j2;cin>>j1>>j2;
        if(j1==j2) continue;
        if(j1<j2) a-=j2;
        else b-=j1;
    }
    printf("%d\n%d", a, b);
    return 0;
}
