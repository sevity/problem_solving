#include <bits/stdc++.h>
using namespace std;
int arr[500001];
int main() {
    int N;scanf("%d", &N);
    for(int i=0;i<N;i++) scanf("%d", arr+i);
    long long ans = 0;
    stack<pair<int,int>> s;
    //페어의 개수라는 개념을 1부터 i-1번째 사람까지 볼수있는사람이라는 컨셉으로 바꾸는게 중요하다.
    for(int i=0;i<N;i++){
        int same_freq=1;
        int cnt = 0;
        //while(s.size() && s.top().first<=arr[i]) cnt+=s.top().second,s.pop();
        while(s.size()){
            if(s.top().first>arr[i]) break;
            if(s.top().first<arr[i]) cnt+=s.top().second;
            else if(s.top().first==arr[i]) cnt+=s.top().second, same_freq=s.top().second+1;
            s.pop();
        }
        //if(s.size() && s.top().first==arr[i]) cnt++; 
        if(s.size()) cnt++;
        ans+= cnt;
        s.push({arr[i], same_freq});
        //printf("%d ", cnt);
    }
    //printf("\n");
    printf("%lld\n", ans);
    return 0;
}
