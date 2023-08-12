#include <bits/stdc++.h>
using namespace std;
int main() {
    int cute = 0;
    int N;cin>>N;while(N--){
        int vote;cin>>vote;
        cute += vote?1:-1;
    }
    cout<<"Junhee is "<<(cute<0?"not ":"") << "cute!";
    return 0;
}
