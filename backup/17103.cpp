#include <bits/stdc++.h>
using namespace std;

vector<bool> sieve(int max)
{
    vector<bool> p(max+1, true);
    p[0] = p[1]=false;
    for(int i=2;i*i<=max;i++)
        for(int j=2;i*j<=max;j++)
            p[i*j]=false;
    return p;
}
int main() {
    vector<bool> prime = sieve(1e6);
    int T; scanf("%d", &T);
    while (T--) {
        int n; scanf("%d", &n);
        int sum = 0;
        for(int i=2;i<=n/2;i++){
            if(prime[i] && prime[n-i]) sum++;
        }
        printf("%d\n", sum);
    }
    return 0;
}

