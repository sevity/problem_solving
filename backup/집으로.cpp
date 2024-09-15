#include <bits/stdc++.h>
using namespace std;

int main() {
    int X, Y, D, T;
    scanf("%d%d%d%d", &X, &Y, &D, &T);
    
    // 현재 위치에서 집까지의 거리 계산
    double dist = sqrt(X * X + Y * Y);

    // 전략1: 무조건 걷기 (거리만큼의 시간)
    double ans = dist;

    // 전략2: 점프 후 남은 거리 걷기
    int jumpCount = dist / D; // 점프할 수 있는 최대 횟수
    double remainingDist = dist - jumpCount * D; // 점프 후 남은 거리
    ans = min(ans, jumpCount * T + remainingDist); // 점프하고 남은 거리 걷기

    // 전략3: 점프해서 지나친 후 되돌아오기
    ans = min(ans, (jumpCount + 1) * T + (D - remainingDist)); // 한 번 더 점프하고 되돌아오기

    // 전략4: 점프를 두 번 해서 마무리
    if(jumpCount==0)
        ans = min(ans, (double)2*T); // 거리가 얼마 안남은 경우
    else
        ans = min(ans, (double)(jumpCount-1) * T + 2*T); // 점프하고 남은 거리 걷기

    // 결과 출력
    printf("%.9f\n", ans);
    
    return 0;
}
