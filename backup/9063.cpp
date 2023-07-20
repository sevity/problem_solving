#include <bits/stdc++.h>
using namespace std;
int main() {
    int N;scanf("%d", &N);
    int minx=10001,maxx=-10001,miny=10001,maxy=-10001;
    while(N--){
        int x,y;scanf("%d%d", &x, &y);
        minx = min(minx, x);
        maxx = max(maxx, x);
        miny = min(miny, y);
        maxy = max(maxy, y);
    }
    printf("%d\n", (maxx-minx)*(maxy-miny));
    return 0;
}
