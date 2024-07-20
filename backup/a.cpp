#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ull = unsigned long long;

bool is_prime(unsigned int n) {
	if (n < 2) return 0;
	if (n % 2 == 0) {
		if (n == 2) return 1;
		else return 0;
	}
	int s = __builtin_ctz(n - 1);
	for (unsigned long long a: {2, 7, 61}) {
		if (a >= n) continue;
		int d = (n - 1) >> s;
		unsigned long long now = 1;
		while (d != 0) {
			if (d & 1) now = (now * a) % n;
			a = (a * a) % n;
			d >>= 1;
		}
		if (now == 1) goto success;
		for (int i = 0; i < s; ++i) {
			if (now == n - 1) goto success;
			now = (now * now) % n;
		}
		return 0;
		success:;
	}
	return 1;
}

int main() {
    int T; scanf("%d", &T);
    while (T--) {
        ll n; scanf("%lld", &n);
        for (ll i = n;i<=abs(n*2)+2; i++) {
            if (is_prime(i)) { printf("%lld\n", i); break; }
        }
    }
    return 0;
}