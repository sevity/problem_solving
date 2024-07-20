#include <bits/stdc++.h>
using namespace std;
int main() {
    int N, r,e,c;cin>>N;while(N--){
        cin>>r>>e>>c;
        if(r==e-c) cout<<"does not matter"<<endl;
        else if(r<e-c) cout<<"advertise"<<endl;
        else cout<<"do not advertise"<<endl;
    }
    
    return 0;
}
