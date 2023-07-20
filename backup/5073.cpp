#include <bits/stdc++.h>
using namespace std;
int main() {
    while(1){
        int arr[3];
        for(int i=0;i<3;i++) scanf("%d", arr+i);
        if(arr[0] == 0) break;
        sort(arr, arr+3);
        if(arr[0]+arr[1]<=arr[2]) {puts("Invalid");continue;}
        if(arr[0]==arr[1] && arr[1] == arr[2]) {puts("Equilateral");continue;}
        if(arr[0]==arr[1] || arr[1] == arr[2]) {puts("Isosceles");continue;}
        puts("Scalene");
    }
    return 0;
}
