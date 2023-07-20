#include <bits/stdc++.h>
using namespace std;
int N, M;
int arr[101][101] = {};
int visit[101][101] = {};
int land_idx = 1;
map<pair<int, int>, int> edge;
void set_vertex()
{
    for(int y=0;y<N;y++)for(int x=0;x<M;x++) {
        if(arr[y][x]==1) {
            queue<int> q;
            q.push(y),q.push(x);
            land_idx++;
            while(q.size()){
                int cy=q.front();q.pop();
                int cx=q.front();q.pop();
                //if(visit[cy][cx]) continue; visit[cy][cx]=1;
                if(arr[cy][cx]!=1) continue;
                //printf("[%d,%d] ", cy,cx);
                arr[cy][cx] = land_idx;
                auto enq = [&](int yy, int xx){
                    if(yy<0||xx<0||yy>=N||xx>=M) return false;
                    if(arr[yy][xx]!=1) return false;
                    //if(visit[yy][xx]) return false;
                    q.push(yy),q.push(xx);
                    return true;
                };
                enq(cy-1,cx), enq(cy+1,cx), enq(cy,cx-1), enq(cy,cx+1);
            }
        }
    }
    //for(int y=0;y<N;y++){ for(int x=0;x<M;x++) printf("%d ", arr[y][x]); puts(""); }
}
void set_edge()
{
    enum State{ BEFORE_START,START, END};
    int start_idx,end_idx,len;
    //가로
    for(int y=0;y<N;y++){
        State state = BEFORE_START;
        for(int x=0;x<M;x++) {
            switch(state){
                case BEFORE_START:
                    if(arr[y][x]>1) start_idx=arr[y][x],len=0,state=START;
                    break;
                case START:
                    if(arr[y][x]==0) len++;
                    if(arr[y][x]==start_idx) len=0;
                    if(arr[y][x]>0 && arr[y][x]!=start_idx) end_idx=arr[y][x],state=END,x--;
                    break;
                case END:
                    if(len>=2){
                        if(edge[{start_idx-1,end_idx-1}]==0) edge[{start_idx-1,end_idx-1}]=len;
                        edge[{start_idx-1,end_idx-1}] = min(edge[{start_idx-1,end_idx-1}], len);
                    }
                    start_idx=arr[y][x],len=0,state=START;
                    break;
            }
        }
    }
    //세로
    for(int x=0;x<M;x++) {
        State state = BEFORE_START;
        for(int y=0;y<N;y++){
            switch(state){
                case BEFORE_START:
                    if(arr[y][x]>1) start_idx=arr[y][x],len=0,state=START;
                    break;
                case START:
                    if(arr[y][x]==0) len++;
                    if(arr[y][x]==start_idx) len=0;
                    if(arr[y][x]>0 && arr[y][x]!=start_idx) end_idx=arr[y][x],state=END,y--;
                    break;
                case END:
                    if(len>=2){
                        if(edge[{start_idx-1,end_idx-1}]==0) edge[{start_idx-1,end_idx-1}]=len;
                        edge[{start_idx-1,end_idx-1}] = min(edge[{start_idx-1,end_idx-1}], len);
                    }
                    start_idx=arr[y][x],len=0,state=START;
                    break;
            }
        }
    }
    //for(auto e:edge) printf("(%d,%d,%d) ", e.first.first, e.first.second, e.second);
}
struct node { int u, v, w; };
int MST_Kruskal(int max_v, vector<node>& v, bool base1=false) {
    if (base1) max_v++;
    struct union_find {
        vector<int> parent;
        int components;
        union_find(int n) : components(n) {
            parent.resize(n + 1);
            for (int i = 0; i <= n; i++) parent[i] = i;
        }
        int find(int x) {
            int ox = x;
            while (parent[x] != x) x = parent[x];
            return parent[ox] = x;
        }
 
        void uni(int x, int y) {
            int xp = find(x), yp = find(y);
            if (xp != yp) {
                parent[yp] = xp;
                components--;
            }
        }
    };

    sort(v.begin(), v.end(), [](node& a, node& b) {return a.w < b.w; });
    union_find uf(max_v);
    int ans = 0;
    for (auto a : v) {
        if (uf.find(a.u) == uf.find(a.v)) continue;
        uf.uni(a.u, a.v);
        ans += a.w;
    }
    
    if (uf.components != 1+base1) return -1;  // 모든 정점을 사용하지 않으면 -1리턴
    return ans;
}
int V, E, A, B, C;
int main() {
    scanf("%d%d", &N, &M);
    for(int y=0;y<N;y++)for(int x=0;x<M;x++) scanf("%d", &arr[y][x]);
    set_vertex();
    set_edge();

    vector<node> v;
    for(auto e:edge) v.push_back({e.first.first, e.first.second, e.second});
    int ans = MST_Kruskal(land_idx-1, v, true);
    cout << (ans==0?-1:ans) << endl;

    return 0;
}
