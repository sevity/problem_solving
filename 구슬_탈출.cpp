#include <bits/stdc++.h>
using namespace std;
int main() {
    int N,M;scanf("%d%d\n", &N, &M);
    char maze[11][11]={};
    int ry=-1,rx=-1,bx=-1,by=-1;
    for(int y=0;y<N;y++)for(int x=0;x<M;x++){
        scanf("\n%c", &maze[y][x]);
        if(maze[y][x]=='R')ry=y,rx=x,maze[y][x]='.';
        if(maze[y][x]=='B')by=y,bx=x,maze[y][x]='.';
    }
    static int visit[11][11][11][11] = {};
    queue<int> q;q.push(ry);q.push(rx);q.push(by);q.push(bx);q.push(1);
    int cry,crx,cby,cbx,move_cnt;
    bool red_found_goal,blue_found_goal;
    int min_move_cnt = 100;
    while(q.size()){
        cry=q.front();q.pop();
        crx=q.front();q.pop();
        cby=q.front();q.pop();
        cbx=q.front();q.pop();
        move_cnt=q.front();q.pop();
        if(move_cnt>=11) continue;
        if(visit[cry][crx][cby][cbx]) continue;
        visit[cry][crx][cby][cbx]=1;
        auto check = [&](int y, int x, int oy, int ox){
            if(y<0||y>=N) return false;
            if(x<0||x>=M) return false;
            if(maze[y][x]!='.' && maze[y][x]!='O') return false;
            if(maze[oy][ox]!='O' && y==oy&&x==ox) return false;
            return true;
        };
        blue_found_goal = false;
        red_found_goal = false;

        auto try_left = [&](int cry, int crx, int cby, int cbx){
            blue_found_goal = false;
            red_found_goal = false;
            //왼쪽
            //R,B가 같은 X라인이면 왼쪽거 먼저 움직여야함 ㄷ
            if(cry==cby && cbx<crx){
                //이경우만 B먼저
                while(check(cby,cbx-1,cry,crx)) {cbx--;if(maze[cby][cbx]=='O')blue_found_goal=true;} 
                while(check(cry,crx-1,cby,cbx)) {crx--;if(maze[cry][crx]=='O')red_found_goal=true;}
            }else{
                //나머지는 R먼저
                while(check(cry,crx-1,cby,cbx)) {crx--;if(maze[cry][crx]=='O')red_found_goal=true;}
                while(check(cby,cbx-1,cry,crx)) {cbx--;if(maze[cby][cbx]=='O')blue_found_goal=true;} 
            }
            if(blue_found_goal==false) q.push(cry),q.push(crx), q.push(cby), q.push(cbx), q.push(move_cnt+1);
            return (blue_found_goal==false && red_found_goal==true);
        };
        if(try_left(cry,crx,cby,cbx)) break;

        auto try_right = [&](int cry, int crx, int cby, int cbx){
            blue_found_goal = false;
            red_found_goal = false;
            //오른쪽
            //R,B가 같은 X라인이면 오른쪽거 먼저 움직여야함 ㄷ
            if(cry==cby && cbx>crx){
                //이경우만 B먼저
                while(check(cby,cbx+1,cry,crx)) {cbx++;if(maze[cby][cbx]=='O')blue_found_goal=true;} 
                while(check(cry,crx+1,cby,cbx)) {
                    crx++;
                    if(maze[cry][crx]=='O')
                        red_found_goal=true;
                }
            }else{
                //나머지는 R먼저
                while(check(cry,crx+1,cby,cbx)) {crx++;if(maze[cry][crx]=='O')red_found_goal=true;}
                while(check(cby,cbx+1,cry,crx)) {cbx++;if(maze[cby][cbx]=='O')blue_found_goal=true;} 
            }
            if(blue_found_goal==false) q.push(cry),q.push(crx), q.push(cby), q.push(cbx), q.push(move_cnt+1);
            return (blue_found_goal==false && red_found_goal==true);
        };
        if(try_right(cry,crx,cby,cbx)) break;

        auto try_up = [&](int cry, int crx, int cby, int cbx){
            blue_found_goal = false;
            red_found_goal = false;
            //위쪽
            //R,B가 같은 Y라인이면 위쪽거 먼저 움직여야함 ㄷ
            if(crx==cbx && cby<cry){
                //이경우만 B먼저
                while(check(cby-1,cbx,cry,crx)) {cby--;if(maze[cby][cbx]=='O')blue_found_goal=true;} 
                while(check(cry-1,crx,cby,cbx)) {cry--;if(maze[cry][crx]=='O')red_found_goal=true;}
            }else{
                //나머지는 R먼저
                while(check(cry-1,crx,cby,cbx)) {cry--;if(maze[cry][crx]=='O')red_found_goal=true;}
                while(check(cby-1,cbx,cry,crx)) {cby--;if(maze[cby][cbx]=='O')blue_found_goal=true;} 
            }
            if(blue_found_goal==false) q.push(cry),q.push(crx), q.push(cby), q.push(cbx), q.push(move_cnt+1);
            return (blue_found_goal==false && red_found_goal==true);
        };
        if(try_up(cry,crx,cby,cbx)) break;

        auto try_down = [&](int cry, int crx, int cby, int cbx){
            blue_found_goal = false;
            red_found_goal = false;
            //아래쪽
            //R,B가 같은 Y라인이면 아래쪽거 먼저 움직여야함 ㄷ
            if(crx==cbx && cby>cry){
                //이경우만 B먼저
                while(check(cby+1,cbx,cry,crx)) {cby++;if(maze[cby][cbx]=='O')blue_found_goal=true;} 
                while(check(cry+1,crx,cby,cbx)) {cry++;if(maze[cry][crx]=='O')red_found_goal=true;}
            }else{
                //나머지는 R먼저
                while(check(cry+1,crx,cby,cbx)) {cry++;if(maze[cry][crx]=='O')red_found_goal=true;}
                while(check(cby+1,cbx,cry,crx)) {cby++;if(maze[cby][cbx]=='O')blue_found_goal=true;} 
            }
            if(blue_found_goal==false) q.push(cry),q.push(crx), q.push(cby), q.push(cbx), q.push(move_cnt+1);
            return (blue_found_goal==false && red_found_goal==true);
        };
        if(try_down(cry,crx,cby,cbx)) break;
        //if(blue_found_goal==false && red_found_goal==true) {          break;        }
        if(visit[cry][crx][cby][cbx]) continue;
        q.push(cry),q.push(crx), q.push(cby), q.push(cbx), q.push(move_cnt+1);
        
    }
    if(blue_found_goal==false && red_found_goal==true)puts("1");
    else puts("0");
    return 0;
}
