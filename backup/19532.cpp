#include <bits/stdc++.h>
using namespace std;
int main() {
    int a,b,c,d,e,f;scanf("%d%d%d%d%d%d", &a, &b, &c, &d, &e, &f);
    for (int x = -999; x <= 999; x++)
        for (int y = -999; y <= 999; y++)
            if(a*x+b*y==c && d*x+e*y==f){
                printf("%d %d\n", x, y);
                return 0;
            }
    return 0;
}
