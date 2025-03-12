#include <bits/stdc++.h>
using namespace std;
int main() {
    int N,K;scanf("%d %d", &N, &K);
    vector<int> v(N);
    for(int i=0;i<N;i++) scanf("%d", &v[i]);
    long double minVar = LDBL_MAX;
    for(;K<=N;K++)
    for(int i=0;i<N;i++) {
        if(i+K>N) break;
        long double avg = 0;for(int j=0;j<K;j++) avg+=v[i+j];avg/=K;
        //printf("avg:%.11lf\n", avg);
        long double var = 0;for(int j=0;j<K;j++) var+=pow(v[i+j]-avg, 2);var/=K;
        //printf("var:%.11lf\n", var);
        if(var<minVar) minVar=var;
    }
    printf("%.11Lf", sqrt(minVar));
    return 0;
}
