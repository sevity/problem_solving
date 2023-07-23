#include <bits/stdc++.h>
using namespace std;
int main() {
    int T;cin >> T;while(T--){
        int cy=0,ck=0;
        for(int i=0;i<9;i++){
            int y,k;cin>>y>>k;
            cy+=y,ck+=k;
        }
        if(cy==ck) puts("Draw");
        else if(cy>ck) puts("Yonsei");
        else puts("Korea");
    }
    return 0;
}
