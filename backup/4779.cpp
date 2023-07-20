#include <bits/stdc++.h>
using namespace std;
void f(int n, bool b_print = true){
    if(n==1) {
        if(b_print) printf("-");
        else printf(" ");
        return;
    }
    f(n/3, b_print);f(n/3,false);f(n/3, b_print);
}
int main() {
    int N; 
    while(scanf("%d", &N) != EOF){
        f(pow(3,N));
        puts("");
    }
    return 0;
}

