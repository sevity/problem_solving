#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) {
    return (a == 0) ? b : gcd(b%a, a);
}
int main() {
    int A0,A1,B0,B1;scanf("%d%d%d%d", &A0, &A1, &B0, &B1);
    int C0,C1;
    C1 = A1*B1;
    C0 = A0*B1 + B0*A1;
    printf("%d %d\n", C0, C1);
    return 0;
}
