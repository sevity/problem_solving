#include <bits/stdc++.h>
using namespace std;
long long get_gcd(long long a, long long b) {
    return (a == 0) ? b : get_gcd(b%a, a);
}
long long arr[100001];
int main() {
    int N;scanf("%d", &N);
    for(int i=0;i<N;i++) scanf("%lld", arr+i);
    long long gcd = get_gcd(arr[1]-arr[0], arr[2]-arr[1]);
    //first turn. get gcd.
    for(int i=2;i<N-1;i++){
        gcd = get_gcd(gcd, arr[i+1]-arr[i]);
    }
    long long sum = 0;
    //next turn calcuate cnt
    for(int i=0;i<N-1;i++){
        long long gap = arr[i+1]-arr[i];
        sum += gap/gcd-1;
    }
    printf("%lld\n", sum);
    return 0;
}
