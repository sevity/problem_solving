#include <bits/stdc++.h>
using namespace std;
int main() {
    int mfee=0,yfee=0;
    int N;cin>>N;while(N--){
        int sec;cin>>sec;
        yfee += sec/30*10+10;
        mfee += sec/60*15+15;
    }
    if(yfee==mfee) printf("Y M %d", yfee);
    else if(yfee<mfee) printf("Y %d", yfee);
    else printf("M %d", mfee);
    return 0;
}
