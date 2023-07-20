#include <bits/stdc++.h>
using namespace std;
int main() {
    int N; scanf("%d", &N);
    map<string, int> m;
    int ans = 0;
    while(N--){
        char name[21];scanf("%s\n", name);
        if(string("ENTER")==name) m.clear();
        else m[name]++;
        if(m[name]==1) ans++;
    }
    printf("%d\n", ans);
    return 0;
}

