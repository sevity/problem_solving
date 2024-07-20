#include <bits/stdc++.h>
using namespace std;
int main() {
    long long a,b;scanf("%lld%lld", &a, &b);
    if(a>b)swap(a,b);
    printf("%lld\n", max((long long)0,b-a-1));
    for(long long i=a+1;i<b;i++){
        printf("%lld ", i);
    }
    return 0;
}
