#include <bits/stdc++.h>
using namespace std;
int main() {
    while(1){
        int N; scanf("%d", &N);
        if(N==-1) break;
        vector<int> factors;
        int factor_sum = 0;
        for(int i=1;i<N;i++){
            if(N%i==0) factor_sum+=i, factors.push_back(i);
        }
        if(factor_sum!=N) printf("%d is NOT perfect.\n", N);
        else{
            printf("%d = ", N);
            for(int i=0;i<factors.size()-1;i++) printf("%d + ", factors[i]);
            printf("%d\n", factors[factors.size()-1]);
        }
    }
    return 0;
}
