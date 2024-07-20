#include <bits/stdc++.h>
using namespace std;

bool my_bsearch(int in[], int N, int find) {
    int left = 0, right = N - 1;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (in[mid] == find) return true;
        if (in[mid] < find) left = mid+1;
        else right = mid-1;
    }
    return false;
}


int A[100001];
int main() {
    int N;scanf("%d",&N);for(int i=0;i<N;i++) scanf("%d", A+i);
    sort(A, A+N);
    int M;cin>>M;while(M--){
        int n;scanf("%d", &n);
        printf("%d\n", binary_search(A, A + N, n));
    }
    return 0;
}
