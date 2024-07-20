#include <bits/stdc++.h>
using namespace std;
int main() {
    int T;cin>>T;while(T--){
        vector<pair<int, string>> v;
        int N;cin>>N;while(N--){
            string school_name;int drink;cin>>school_name>>drink;
            v.push_back({drink, school_name});
        }
        sort(v.rbegin(), v.rend());
        cout << v[0].second << endl;
    }
    return 0;
}
