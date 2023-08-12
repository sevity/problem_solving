#include <bits/stdc++.h>
using namespace std;
int main() {
    string str;cin >> str;
    int max_val = 0;
    for(int i=0;i<str.size();i++){
        for(int j=i+1;j<str.size();j+=2){
            if(i==2 && j==5){
                int sdf = 1;
            }
            int sum1=0;for(int k=i;k<=(i+j)/2;k++)sum1+=str[k]-'0';
            int sum2=0;for(int k=(i+j)/2+1;k<=j;k++)sum2+=str[k]-'0';
            if(sum1==sum2) max_val=max(max_val, j-i+1);
        }
    }
    printf("%d", max_val);
    return 0;
}

