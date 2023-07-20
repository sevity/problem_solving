#include <bits/stdc++.h>
using namespace std;
int main(){
    char subject[51] = {};
    double credit;
    char grade[3];
    int N=20;
    map<string, double> m;
    m["A+"] = 4.5;
    m["A0"] = 4.0;
    m["B+"] = 3.5;
    m["B0"] = 3.0;
    m["C+"] = 2.5;
    m["C0"] = 2.0;
    m["D+"] = 1.5;
    m["D0"] = 1.0;
    m["F"] = 0.0;
    double sum = 0;
    double credit_sum = 0;
    while(N--){
        scanf("%s %lf %s\n", subject, &credit, grade);
        if(strcmp(grade, "P")==0) continue;
        sum += m[grade] * credit;
        credit_sum += credit;
    }
    printf("%lf\n", sum/credit_sum);
    return 0;
}
