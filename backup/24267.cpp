#include <bits/stdc++.h>
using namespace std;
int main() {
    long long N;scanf("%lld", &N);
    long long sum = 0;
    for(int i=1;i<=N-2;i++)
        sum += (((N-1)-(i+1)+1)*((N-1)-(i+1)+2))/2;
    printf("%lld\n3", sum);
    return 0;
}
