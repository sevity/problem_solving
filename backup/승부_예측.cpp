#include <bits/stdc++.h>
using namespace std;
double note[4][4][3];
double promote[4];
map<int,pair<int,int>> m0;

void go(int ix, double prob, vector<int> score){
    if(ix==6) {
        //1등일 확률
        vector<int> s2 = score;
        sort(s2 .rbegin(), s2.rend());
        vector<pair<int,int>> s3;
        for(int i=0;i<4;i++) s3.push_back(make_pair(i,score[i]));
        sort(s3.begin(),s3.end(),[](pair<int,int>a,pair<int,int>b){return a.second>b.second;});

//1. 4개의 나라의 점수가 모두 동일
//2. 1,2,3등 나라의 점수가 모두 동일
//3. 2,3,4등 나라의 점수가 모두 동일
//4. 2,3등 나라의 점수가 동일 (나머지는 상이)
//5. 그외
        if(s2[0]==s2[1] && s2[1]==s2[2] && s2[2]==s2[3])
        {
            for(int i=0;i<4;i++) promote[i]+=prob/2;
        } else if(s2[0]==s2[1] && s2[1]==s2[2]) {
            promote[s3[0].first]+=prob*2/3;
            promote[s3[1].first]+=prob*2/3;
            promote[s3[2].first]+=prob*2/3;

        } else if(s2[1]==s2[2] && s2[2]==s2[3]) {
            promote[s3[0].first]+=prob;
            promote[s3[1].first]+=prob*1/3;
            promote[s3[2].first]+=prob*1/3;
            promote[s3[3].first]+=prob*1/3;
        } else if(s2[1]==s2[2]){
            promote[s3[0].first]+=prob;
            promote[s3[1].first]+=prob*1/2;
            promote[s3[2].first]+=prob*1/2;
        }else {
            promote[s3[0].first]+=prob;
            promote[s3[1].first]+=prob;
        }
        return;
    }
    //승
    score[m0[ix].first]+=3;
    go(ix+1, prob*note[m0[ix].first][m0[ix].second][0], score);
    score[m0[ix].first]-=3;
    //무
    score[m0[ix].first]+=1;
    score[m0[ix].second]+=1;
    go(ix+1, prob*note[m0[ix].first][m0[ix].second][1], score);
    score[m0[ix].first]-=1;
    score[m0[ix].second]-=1;
    //패
    score[m0[ix].second]+=3;
    go(ix+1, prob*note[m0[ix].first][m0[ix].second][2], score);
    score[m0[ix].second]-=3;
}
int main() {
    m0[0] = {0,1};
    m0[1] = {0,2};
    m0[2] = {0,3};
    m0[3] = {1,2};
    m0[4] = {1,3};
    m0[5] = {2,3};

    map<string, int> m;
    char name[11];for(int i=0;i<4;i++) {
        scanf("%s", name);
        m[name]=i;
    }
    for(int i=0;i<6;i++){
        char name[11];
        scanf("%s", name);int team1=m[name];
        scanf("%s", name);int team2=m[name];
        double w,d,l;scanf("%lf%lf%lf",&w,&d,&l);
        note[team1][team2][0] = note[team2][team1][2] = w;
        note[team1][team2][1] = note[team2][team1][1] = d;
        note[team1][team2][2] = note[team2][team1][0] = l;
    }
    //각 팀별로 승승승 부터 패패패까지 모두 돌려서 시뮬레이션 해보면 될거 같은데..
    //printf("aa %lf\n", note[2][0]);
    go(0,1,{0,0,0,0});
    for(int i=0;i<4;i++){
        printf("%lf\n", promote[i]);
    }

    return 0;
}
