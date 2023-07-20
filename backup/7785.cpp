#include <bits/stdc++.h>
using namespace std;
int main() {
    int N;scanf("%d", &N);
    map<string, int>m;
    while(N--){
        char name[6],status[6];
        scanf("%s %s\n", name, status);
        m[name] = ((strcmp(status,"enter")==0)?1:0);
    }
    vector<string> v;
    for(auto e : m){
        if(e.second) v.push_back(e.first);
    }
    sort(v.rbegin(), v.rend());
    for(auto e : v){
        printf("%s\n", e.c_str());
    }
    return 0;
}
