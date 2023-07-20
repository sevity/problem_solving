#include <bits/stdc++.h>
using namespace std;
int arr[500001];
int main() {
    int N;scanf("%d", &N);
    for(int i=0;i<N;i++) scanf("%d", arr+i);
    long long ans = 0;
    for(int i=0;i<N;i++)for(int j=i+1;j<N;j++){
        int maxv = min(arr[i], arr[j]);
        bool ok = true;
        for(int k=i+1;k<j;k++)
            if(arr[k]>maxv) {ok = false;break; }
        if(ok) ans++;
    }
    printf("%lld\n", ans);
    return 0;
}
