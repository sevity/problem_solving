#include <bits/stdc++.h>
using namespace std;
int main() {
    int n;scanf("%d",&n);
    deque<pair<int, int>> q; 
    for(int i=0;i<n;i++) {int a;scanf("%d", &a);q.push_back(make_pair(i+1, a));}
    while(q.size()>0){
        pair<int, int> v = q.front();q.pop_front();
        printf("%d ", v.first); 
        if(v.second>0) {v.second--;while(v.second--) q.push_back(q.front()),q.pop_front();}
        else {v.second*=-1;while(v.second--) q.push_front(q.back()),q.pop_back();}
    }
    return 0;
}
