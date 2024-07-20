#include <bits/stdc++.h>
using namespace std;
#define REP(i,n) for(int i=0;i<(int)(n);i++)
#define REP1(i,n) for(int i=1;i<=(int)(n);i++)
using vi = vector<int>;
typedef long long ll;
const int INF = (int)1e9;

int32_t main()
{
    int n;scanf("%d", &n);
    stack<int> s;
    while(n--){
        int cmd;scanf("%d", &cmd);
        switch(cmd){
            case 1:
                int x;scanf("%d", &x);s.push(x);
                break;
            case 2:
                if(s.empty()) printf("-1\n");
                else {
                    int t;printf("%d\n", s.top());s.pop();
                }
                break;
            case 3:
                printf("%d\n", s.size());
                break;
            case 4:
                printf("%d\n", s.empty()?1:0);
                break;
            case 5:
                if(s.empty()) printf("-1\n");
                else {
                    int t;printf("%d\n", s.top());
                }
                break;
        }
    }

    return 0;
}