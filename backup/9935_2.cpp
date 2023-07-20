#include <bits/stdc++.h>
using namespace std;
int main() {
    string text,bomb,ans;
    cin >> text >> bomb;
    for(auto c:text){
        ans+=c;
        if(ans.length()>=bomb.length()){
            bool same = true;
            for(int i=0;i<bomb.length();i++){
                if(bomb[i]!= ans[ans.length()-bomb.length()+i]) { same=false;break; }
            }
            if(same) ans.erase(ans.size()-bomb.length()); 
        }   
    }
    if(ans.length()==0) ans="FRULA";
    cout << ans <<endl;
    return 0;
}

