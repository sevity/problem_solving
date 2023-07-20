#include <bits/stdc++.h>
using namespace std;
#define ll long long

bool is_prime(ll n){
    if(n<2) return false;
    for(ll i=2;i*i<=n;i++){
        if(n%i==0) return false;
    }
    return true;
}

int main() {
    int T; scanf("%d", &T);
    while (T--) {
        ll n; scanf("%lld", &n);
        for (ll i = n;i<=abs(2*n); i++) {
            if (is_prime(i)) { printf("%lld\n", i); break; }
        }
    }
    return 0;
}
