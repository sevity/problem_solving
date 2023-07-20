#include <stdio.h>

bool prime(int a)
{
    if(a<=1) return false;
    bool is_prime = true;
    for(int i=2;i<a;i++)
    {
        if(a%i==0) is_prime=false;
    }
    return is_prime;
}

int main(void)
{
    int n,r=0;
    scanf("%d", &n);
    for(int i=0;i<n;i++)
    {
        int a;
        scanf("%d", &a);
        if(prime(a)) r++;
    }
    printf("%d\n", r);
    return 0;
}