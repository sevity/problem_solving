#include <bits/stdc++.h>
using namespace std;
int main(){
    char matrix[5+1][15+1] = {};
    for(int i=0;i<5;i++){
        char str[15+1];scanf("%s\n", str);
        for(int j=0;j<strlen(str);j++) matrix[i][j] = str[j];
    }
    for(int x=0;x<15;x++){
        for(int y=0;y<5;y++){
            if(matrix[y][x]) printf("%c", matrix[y][x]);
        }
    }
    return 0;
}
