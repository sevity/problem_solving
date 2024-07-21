#include <bits/stdc++.h>
using namespace std;
int main() {
    deque<int> q;
    int n;scanf("%d", &n);
    while(n--){
        int cmd;scanf("%d", &cmd);
        int v;
        switch (cmd)
        {
        case 1: scanf("%d", &v);q.push_front(v); break;
        case 2: scanf("%d", &v);q.push_back(v); break;
        case 3: 
            if(q.empty()) printf("%d\n", -1);
            else {printf("%d\n", q.front());q.pop_front();}
            break;
        case 4: 
            if(q.empty()) printf("%d\n", -1);
            else {printf("%d\n", q.back());q.pop_back();}
            break;
        case 5: printf("%d\n", q.size()); break;
        case 6: printf("%d\n", q.empty()?1:0);break;
        case 7: 
            if(q.empty()) printf("%d\n", -1);
            else {printf("%d\n", q.front());}
            break;
        case 8: 
            if(q.empty()) printf("%d\n", -1);
            else {printf("%d\n", q.back());}
            break;
        
        }
    }
    
    return 0;
}
