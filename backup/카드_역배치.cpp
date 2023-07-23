#include <bits/stdc++.h>
using namespace std;
int main() {
    int card[21];for(int i=1;i<=20;i++) card[i]=i;
    for(int i=0;i<10;i++){
        int f,t;cin>>f>>t;
        reverse(card+f, card+t+1);
    }
    for(int i=1;i<=20;i++)printf("%d ", card[i]);
    return 0;
}
