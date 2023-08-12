#include <bits/stdc++.h>
using namespace std;
void print_line(int i, int n){
    for(int j=0;j<i;j++) printf("*");
    for(int j=0;j<(n-i)*2;j++) printf(" ");
    for(int j=0;j<i;j++) printf("*");
    puts("");
}
int main() {
    int n;cin>>n;
    for(int i=1;i<=n;i++) print_line(i, n);
    for(int i=n-1;i>=1;i--) print_line(i, n);
    return 0;
}
