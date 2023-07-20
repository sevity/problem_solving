#include <bits/stdc++.h>
using namespace std;
int main() {
    int arr[3];
    for(int i=0;i<3;i++) scanf("%d", arr+i);
    sort(arr, arr+3);
    int A = arr[0] + arr[1];
    int B = min(A-1,arr[2]);
    printf("%d\n", A+B);
    return 0;
}
