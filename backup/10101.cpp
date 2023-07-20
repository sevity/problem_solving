#include <bits/stdc++.h>
using namespace std;
int main() {
    int arr[3];
    for(int i=0;i<3;i++) scanf("%d", arr+i);
    sort(arr, arr+3);
    if(arr[0]+arr[1]+arr[2] != 180) {puts("Error");return 0;}
    if(arr[0]==arr[1] && arr[1] == arr[2]) {puts("Equilateral");return 0;}
    if(arr[0]==arr[1] || arr[1] == arr[2]) {puts("Isosceles");return 0;}
    puts("Scalene");
    return 0;
}
