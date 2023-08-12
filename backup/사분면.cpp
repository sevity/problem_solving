#include <bits/stdc++.h>
using namespace std;
int main() {
    int q[5] = {};
    int n;cin>>n;while(n--){
        int a,b;cin>>a>>b;
        if(a==0||b==0)q[0]++;
        else if(a>0&&b>0)q[1]++;
        else if(a<0&&b>0)q[2]++;
        else if(a<0&&b<0)q[3]++;
        else q[4]++;
    }
    for(int i=0;i<5;i++){
        if(i==4)cout<<"AXIS: "<<q[0]<<endl;
        else cout<<"Q"<<i+1<<": "<<q[i+1]<<endl;
    }
    return 0;
}
