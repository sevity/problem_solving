#include <bits/stdc++.h>
using namespace std;
int main() {
    int N; scanf("%d", &N);
    map<string, int> m;
    int ans = 0;
    while(N--){
        char name1[21], name2[21];scanf("%s %s\n", name1, name2);
        if(string("ChongChong")==name1) m[name1]++;
        if(string("ChongChong")==name2) m[name2]++;
        if(m[name1]) m[name2]++;
        if(m[name2]) m[name1]++;
    }
    for(auto e:m) if(e.second>0) ans++;
    printf("%d\n", ans);
    return 0;
}

