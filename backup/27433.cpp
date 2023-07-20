#include <bits/stdc++.h>
using namespace std;
long long fact(long long n){
    if(n==0) return 1;
    return n* fact(n-1);
}
int main() {
    int N; scanf("%d", &N);
    printf("%lld\n", fact(N));
    return 0;
}

