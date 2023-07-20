#include <bits/stdc++.h>
using namespace std;
struct point {double x,y;};
double CCW(point A, point B, point C) {
    return (B.x - A.x) * (C.y - A.y) - (C.x - A.x) * (B.y - A.y);
}
int main() {
    int arr[8];for(int i=0;i<8;i++)scanf("%d", arr+i);
    double pi = 3.1415926;
    vector<point> points;
    int sorted_idx[8] = {0,1,2,3,4,5,6,7};
    int ans = 0;
    for(int i=0;i<8;i++){
        double r = arr[i];
        double theta = 2 * pi * i / 8;
        double x = r * cos(theta);
        double y = r * sin(theta);
        points.push_back({x,y});
        //printf("[%lf, %lf] ", x,y);
    }
    do{
        int* si = sorted_idx;
        bool ok = true;
        for(int i=0;i<8;i++) {
            if(CCW(points[si[i]],
                    points[si[(i+1)%8]],
                    points[si[(i+2)%8]])<=0){
                ok = false;break;}
        }
        if(ok) ans++;
    }while(next_permutation(sorted_idx, sorted_idx+8));
    printf("%d", ans);
    return 0;
}
