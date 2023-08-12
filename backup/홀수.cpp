#include <bits/stdc++.h>
using namespace std;
int main() {
    int sum = 0, min_val=INT_MAX;
    for(int i=0;i<7;i++){
        int n;cin>>n;
        if(n%2) sum+=n,min_val=min(min_val, n);
    }
    if(sum==0) puts("-1");
    else printf("%d\n%d", sum, min_val);
    return 0;
}
