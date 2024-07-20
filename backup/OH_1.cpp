#include <iostream>
#include <vector>
using namespace std;

int longestHappyPeriod(const std::vector<int>& happiness) {
    int n = happiness.size();
    int ans = 0;
    int cnt_h = 0, cnt_u = 0;
    int s = 0;

    for (int e = 0; e < n; e++) {
        if (happiness[e] > 8) {
            cnt_h++;
        } else {
            cnt_u++;
        }

        while (cnt_h <= cnt_u && s <= e) {
            if (happiness[s] > 8) {
                cnt_h--;
            } else {
                cnt_u--;
            }
            s++;
        }

        if (cnt_h > cnt_u) {
            ans = max(ans, e - s + 1);
        }
    }

    return ans;
}

int main() {
    std::vector<int> happiness = {6, 10, 3, 9, 4, 10, 3, 9, 3, 10, 6};
    std::cout << "Longest happy period: " << longestHappyPeriod(happiness) << '\n'; // 출력: 9
    return 0;
}
