#include <bits/stdc++.h>
using namespace std;
int main() {
    long long N;scanf("%lld", &N);
    long long sum = 0;
    for(int i=1;i<=N-1;i++) sum+= N-(i+1)+1;
    printf("%lld\n2", sum);
    return 0;
}
