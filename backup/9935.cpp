#include <bits/stdc++.h>
using namespace std;
int main() {
    string text,bomb;
    cin >> text >> bomb;
    stack<pair<char, int>> s;
    int match_idx = -1;
    for(int i=0;i<text.length();i++){
        if(text[i]==bomb[match_idx+1]) match_idx++;
        else match_idx= (text[i]==bomb[0])?0:-1;
        s.push({text[i], match_idx});

        if(match_idx==bomb.length()-1){
            for(int j=0;j<bomb.length();j++) s.pop();
            if(s.empty()) match_idx=-1;
            else match_idx = s.top().second;
        }
    }
    string ans;
    while(!s.empty()){
        ans += s.top().first;
        s.pop();
    }
    reverse(ans.begin(), ans.end());
    if(ans.length()==0) ans="FRULA";
    cout << ans <<endl;
    return 0;
}

