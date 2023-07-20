#include <bits/stdc++.h>
using namespace std;
int main() {
    while(true){
        int n;scanf("%d", &n);
        vector<int> v;
        if(n==-1) break;
        for(int i=1;i<n;i++){
            if(n%i==0) v.push_back(i);
        }
        int sum = 0;for(auto e:v)sum+=e;
        if(sum!=n) {printf("%d is NOT perfect.\n", n);continue;}
        printf("%d = ",n);
        for(int i=0;i<v.size()-1;i++){
            printf("%d + ", v[i]);
        }printf("%d\n", v[v.size()-1]);
    }
    return 0;
}
