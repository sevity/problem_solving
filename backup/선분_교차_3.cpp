#include <bits/stdc++.h>
#define int long long
using namespace std;
#define REP(i,n) for(int i=1;i<=(int)(n);i++)

struct point { double x, y; 
    bool operator==(const point& other) const {return x == other.x && y == other.y;}
    bool operator<=(const point& other) const {return y < other.y || (y == other.y && x <= other.x);}
    bool operator>(const point& other) const {return y > other.y || (y == other.y && x > other.x);}
};
double CCW(point A, point B, point C, bool sign_only=true) {
    double r = (B.x - A.x) * (C.y - A.y) - (C.x - A.x) * (B.y - A.y);
    if (sign_only == false) return r;
    if (r == 0)return 0;
    return r > 0 ? 1 : -1;
}
struct line { point s, e; };
//touch_ok가 false이면, 두 선분이 교차하지 않고 만나기만 하는 경우에는 false를 리턴
bool Intersect(line x, line y, bool touch_ok=false) {
    point a = x.s, b = x.e;
    point c = y.s, d = y.e;
    double ab = CCW(a, b, c) * CCW(a, b, d);
    double cd = CCW(c, d, a) * CCW(c, d, b);
    if (ab == 0 && cd == 0) {
        pair<int, int> aa = { a.x, a.y }, bb = { b.x,b.y }, 
            cc = { c.x, c.y }, dd = { d.x,d.y };
        if (aa > bb)swap(aa, bb);
        if (cc > dd)swap(cc, dd);
        if(touch_ok) return cc <= bb && aa <= dd;
        return cc < bb && aa < dd;
    }
    if(touch_ok) return ab <= 0 && cd <= 0;
    return ab < 0 && cd < 0;
}
bool find_intersection(line l1, line l2, point& out) // 교점 구하기
{
    point A = l1.s, B=l1.e, C=l2.s, D=l2.e;
	if (A > B) swap(A, B);
	if (C > D) swap(C, D);
	double px = (A.x * B.y - A.y * B.x) * (C.x - D.x) - (A.x - B.x) * (C.x * D.y - C.y * D.x);
	double py = (A.x * B.y - A.y * B.x) * (C.y - D.y) - (A.y - B.y) * (C.x * D.y - C.y * D.x);
	double p = (A.x - B.x) * (C.y - D.y) - (A.y - B.y) * (C.x - D.x);

    bool found = false;
	if (p == 0) // 평행할 때
	{
		// 교점이 하나일 때
		if (B == C && A <= C) found=true, out = B;
		else if (A == D && C <= A) found=true, out = A;
	}
	else // 교차할 때
	{
		double x = px / p;
		double y = py / p;
        out = {x,y};
        found=true;
	}
    return found;
}


int32_t main()
{
    ios::sync_with_stdio(0); cin.tie(0);
    vector<line> l;
    double a, b, c, d; REP(i, 2)cin >> a >> b >> c >> d, l.push_back({ a,b,c,d });
    if(Intersect(l[0], l[1], true)==false) puts("0");
    else{
        puts("1");
        point intercection;
        bool found = find_intersection(l[0], l[1], intercection);
        if(found) printf("%.16lf %.16lf", intercection.x, intercection.y);
    }
    return 0;
}



