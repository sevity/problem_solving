#include <bits/stdc++.h>
using namespace std;

int N;
int solution(int arr[]){
    vector<set<int>> vs;
    for(int i=0;i<N;i++){
        int biggest = -1;
        for(int j=0;j<vs.size();j++){
            if(vs[j].size()==0) continue;
            int rb = *(vs[j].rbegin());
            if(arr[i] > rb)
                biggest = max(biggest, *vs[j].rbegin());
        }
        if(biggest==-1) {
            printf("adding %d\n", arr[i]);
            vs.push_back({arr[i]});
            continue;
        }
        for(int j=0;j<vs.size();j++){
            int rb = *(vs[j].rbegin());
            if(rb == biggest){
                vs[j].insert(arr[i]);
                break;
            }
        }
    }
    for(auto& s : vs){
        for(int n : s) printf("%d ", n);
        printf("\n");
    }
    return vs.size();
}

int A[10001];
int main(void){
    //scanf("%d", &N);
    N=6;
    for(int i=0;i<N;i++) {
        scanf("%d", A+i);
    }
    int ans = solution(A);
    printf("%d\n", ans);
    return 0;
}
