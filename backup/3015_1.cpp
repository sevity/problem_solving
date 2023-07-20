#include <bits/stdc++.h>
using namespace std;
int arr[500001], okn[500001], lkn[500001];
int main() {
    int N;scanf("%d", &N);
    for(int i=0;i<N;i++) scanf("%d", arr+i);
    long long ans = 0;

    stack<pair<int,int>> s;
    //오큰수 구하자
    for(int i=N-1;i>=0;i--){
        while(s.size()>0 && s.top().second<=arr[i]) s.pop();
        if(s.empty()) okn[i]=-1;
        else okn[i]=s.top().first;
        s.push({i, arr[i]});
    }
    //왼큰수 구하자
    s = stack<pair<int, int>>();
    for(int i=0;i<N;i++){
        while(s.size()>0 && s.top().second<=arr[i]) s.pop();
        if(s.empty()) lkn[i]=-1;
        else lkn[i]=s.top().first;
        s.push({i,arr[i]});
    }
    for(int i=0;i<N;i++) printf("%d ", okn[i]); puts("");
    for(int i=0;i<N;i++) printf("%d ", lkn[i]); puts("");
    for(int i=0;i<N;i++)for(int j=i+1;j<N;j++){
        if(
            (okn[i]==-1 || okn[i]>=j) && 
            (lkn[j]==-1 || lkn[j]<=i)  ) 
        {
            printf("[%d,%d] ", i,j);
            ans++;
            
        }
    }
    printf("%lld\n", ans);
    return 0;
}
