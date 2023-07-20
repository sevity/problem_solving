#include <bits/stdc++.h>
using namespace std;
int main() {
    int A[30] = {};
    for(int i=0;i<28;i++) {
        int n;scanf("%d", &n);
        A[n-1]++;
    }
    for(int i=0;i<30;i++) {
        if(A[i]==0) printf("%d\n", i+1);
    }
    return 0;
}
