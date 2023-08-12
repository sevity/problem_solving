#include <bits/stdc++.h>
using namespace std;
int main() {
    int K, N, M; cin >> K >> N >> M;
    cout << max(0,K*N-M);
    return 0;
}
