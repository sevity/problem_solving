#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

// 주어진 gcd 함수 (유클리드 알고리즘)
ll gcd(ll a, ll b) {
    while (b > 0) {         
        ll t = a % b;         
        a = b; 
        b = t;     
    }     
    return a; 
}

int main() {
    int N;
    scanf("%d", &N);
    
    ll balance = 0;    // 초기 카카오머니 잔액 0
    ll G = 0;          // 충전 거래에 대한 T값들의 gcd (초기 0)
    ll max_b = 0;      // 모든 충전 거래에서의 b값 중 최대값
    bool valid = true; // 로그 모순 체크
    
    for (int i = 0; i < N; i++){
        ll a, b;
        scanf("%lld %lld", &a, &b);
        
        if(a > 0) { // 입금인 경우
            balance += a;
            if(balance != b) {
                valid = false;
                break;
            }
        } else { // 출금인 경우 (a < 0, x = -a)
            ll x = -a;
            if(balance >= x) { 
                // 잔액만으로 결제 가능한 경우: 잔액에서 x만큼 차감되어야 함.
                if(balance - x != b){
                    valid = false;
                    break;
                }
                balance = b;
            } else {
                // 충전이 필요한 경우: 
                // 여러 번 M을 충전해서 balance + k * M >= x가 되고,
                // 최종적으로 balance + k * M - x = b가 되어야 한다.
                // 따라서 k * M = (x - balance) + b 라는 조건이 성립.
                ll T = (x - balance) + b;
                if(G == 0) G = T;
                else G = gcd(G, T);
                
                // 충전 거래에서는 M이 b보다 커야 한다는 조건도 있으므로
                max_b = max(max_b, b);
                balance = b;
            }
        }
    }
    
    if(!valid) {
        printf("-1");
        return 0;
    }
    
    // 충전 거래가 한 번도 발생하지 않은 경우 (G == 0)
    // 이 경우에는 어떤 M이든 상관없으므로 문제에서 요구하는 범위 내에서 1을 출력해도 된다.
    if(G == 0){
        printf("1");
        return 0;
    }
    
    // 모든 충전 거래에 대해 M은 G의 약수여야 하고, 각 거래에서 b < M 이어야 함.
    if(G <= max_b){
        printf("-1");
        return 0;
    }
    
    // 조건을 만족하는 M 중 하나로 G를 출력 (문제에서 가능한 값이 여러 개라면 아무거나 출력)
    printf("%lld", G);
    return 0;
}
