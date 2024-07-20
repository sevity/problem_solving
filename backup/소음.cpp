#include <bits/stdc++.h>
using namespace std;
int main() {
    char A[101], B[101], op[2];
    scanf("%s\n%s\n%s", A, op, B);
    if(op[0]=='*') {
        printf("1");
        for(int i=0;i<strlen(A)+strlen(B)-2;i++) printf("0");
    }else{
        char* l = A;
        char* s = B;
        if(strlen(B)>strlen(A)) swap(l,s);
        l[strlen(l)-strlen(s)] += 1;
        printf("%s", l);
    }
    return 0;
}
