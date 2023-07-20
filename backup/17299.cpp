#include <bits/stdc++.h>
using namespace std;
int arr[1000001];
int ans[1000001];
int F[1000001];
int main() {
    int N;scanf("%d", &N);
    for(int i=0;i<N;i++) scanf("%d", arr+i);
    for(int i=0;i<N;i++) F[arr[i]]++;
    stack<pair<int, int>> s;
    vector<int> v;
    for(int i=N-1;i>=0;i--){
        while(s.size()>0 && s.top().second <= F[arr[i]]) s.pop();
        ans[i] = s.empty()?-1:s.top().first;
        if(F[arr[i]]>1) s.push({arr[i], F[arr[i]]});
    }
    for(int i=0;i<N;i++) printf("%d ", ans[i]);
    return 0;
}
