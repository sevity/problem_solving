#include <bits/stdc++.h>
using namespace std;
int main() {
    int arr[5];for(int i=0;i<5;i++)scanf("%d", arr+i);
    sort(arr, arr+5);
    int sum = 0; for(int i=0;i<5;i++) sum+= arr[i];
    printf("%d\n%d", sum/5, arr[2]);
    return 0;
}
