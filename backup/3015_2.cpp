#include <bits/stdc++.h>
using namespace std;
int arr[500001], okn[500001], lkn[500001];
int main() {
    int N;scanf("%d", &N);
    for(int i=0;i<N;i++) scanf("%d", arr+i);
    long long ans = 0;
    stack<pair<int,int>> s;
    //페어의 개수라는 개념을 1부터 i-1번째 사람까지 볼수있는사람이라는 컨셉으로 바꾸는게 중요하다.
    for(int i=0;i<N;i++){
        int cnt = 0;
        if(i>0) cnt++;
        while(s.size() && s.top().first<arr[i]) cnt+=s.top().second,s.pop();
        ans+= cnt;
        printf("%d ", cnt);
        s.push({arr[i], cnt});
    }
    printf("\n");
    printf("%lld\n", ans);
    return 0;
}
