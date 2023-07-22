#include <bits/stdc++.h>
using namespace std;
int main() {
    int N; scanf("%d", &N);
    int sum = 0;
    while(N--){
        int local_sum = 0;
        int a,b,c;scanf("%d%d%d", &a, &b, &c);
        if(a==b&&b==c) local_sum+=10000+a*1000;
        else if(a==b || b==c) local_sum+=1000+b*100;
        else if(a==c) local_sum+=1000+a*100;
        else local_sum+=max(max(a,b),c)*100;
        sum = max(sum, local_sum);
    }
    printf("%d", sum);
    return 0;
}
