#include <bits/stdc++.h>
using namespace std;
map<string, int> cnt;
int main() {
    int N, M; scanf("%d%d\n", &N, &M);
    vector<string> v;
    while(N--) {
        char word[11];scanf("%s\n", word);
        if(strlen(word)<M) continue;
        cnt[word]++;
        if(cnt[word]==1) v.push_back(word);
    }
    sort(v.begin(), v.end(), [&](string& a, string& b){
        if(cnt[a]!=cnt[b]){
            return cnt[a]>cnt[b];  // 출현빈도 기준 내림차순
        }
        if(a.length() != b.length()){
            return a.length()>b.length();  // 단어 길이에 따른 내림차순
        }
        return a < b;  // 사전순
    });
    for(auto e:v) printf("%s\n", e.c_str());
    return 0;
}

