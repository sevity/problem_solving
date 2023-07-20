#include <bits/stdc++.h>
using namespace std;
int main(){
    char str[101] = {};scanf("%s", str);
    bool p = true;
    for(int i=0;i<strlen(str);i++){
       if(str[i] != str[strlen(str)-1-i]) {p=false;break;} 
    }
    printf("%d\n", p);
    return 0;
}
