#include <iostream>
#include <vector>
#include <algorithm>

int main() {
    int N;
    std::cin >> N;

    std::vector<int> arr(N);
    for(int i = 0; i < N; i++) {
        std::cin >> arr[i];
    }

    std::vector<int> LIS;
    for(int i = 0; i < N; i++) {
        if(LIS.empty() || LIS.back() < arr[i]) {
            LIS.push_back(arr[i]);
        } else {
            auto it = std::lower_bound(LIS.begin(), LIS.end(), arr[i]);
            *it = arr[i];
        }
    }

    std::cout << LIS.size() << std::endl;
    return 0;
}
