#include <bits/stdc++.h>
using namespace std;
int main() {
    vector<vector<int>> v1 = {{500,1}, {300,2}, {200,3}, {50,4}, {30,5}, {10,6}};
    vector<vector<int>> v2 = {{512,1}, {256,2}, {128,4}, {64,8}, {32,16}};
    int T;scanf("%d", &T);
    while(T--) {
        int a, b;scanf("%d %d", &a, &b);
        int sum = 0;
        if(a>0) for(int i=0;i<v1.size();i++) {
            a-=v1[i][1];if(a<=0) {sum+=v1[i][0];break;}
        }
        if(b>0) for(int i=0;i<v2.size();i++) {
            b-=v2[i][1];if(b<=0) {sum+=v2[i][0];break;}
        }
        printf("%d\n", sum*10000);
    }
    return 0;
}
