#include <bits/stdc++.h>
using namespace std;
int main() {
    int V;cin>>V;
    string s;cin>>s;
    int ac=0,bc=0;for(auto e:s)if(e=='A')ac++;else bc++;
    if(ac==bc)cout<<"Tie";
    else if(ac>bc)cout<<"A";
    else cout<<"B";
    return 0;
}
