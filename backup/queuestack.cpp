#include <bits/stdc++.h>
using namespace std;
int bStack[100001];
int arr2[100001];
int main() {
    int N;scanf("%d", &N);
    for(int i=0;i<N;i++) {int n;scanf("%d", &n);bStack[i] = n;}
    vector<int> vi;
    for(int i=0;i<N;i++) {
        int n;scanf("%d", &n);
        if(!bStack[i]) vi.push_back(n);
    }
    int M;scanf("%d", &M);
    for(int i=0;i<M;i++) {scanf("%d", arr2+i);}
    N = vi.size();
    reverse(vi.begin(), vi.end());

    if(N>M) {
        for(int i=0;i<M;i++) printf("%d ", vi[i]);
    } else {
        for(int i=0;i<N;i++) printf("%d ", vi[i]);
        for(int i=0;i<M-N;i++) {
            printf("%d ", arr2[i]);
        }
    }


    return 0;
}
/*
1 2 3 4
q s s q
2

2 2 3 1
q s s q
4

4 2 3 2
q s s q
1

7 2 3 4
q s s q
2



무조건 4가 출력되네
그담은 1이네.. 

*/