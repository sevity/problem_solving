#include <bits/stdc++.h>
using namespace std;
int main() {
    int ans = 0;
    int N; scanf("%d", &N);
    for(int i=1;i*i<=N;i++) ans++;
    printf("%d\n", ans);
    return 0;
}

