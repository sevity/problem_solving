#include <bits/stdc++.h>
using namespace std;
int main(){
    int N;scanf("%d", &N);
    while(N--){
        char str[11] = {};
        scanf("%s", str);
        printf("%c%c\n", str[0], str[strlen(str)-1]);
    }
    return 0;
}
