/*Santiago Zubieta*/
#include <iostream>
#include <numeric>
#include <fstream>
#include <climits>
#include <cstring>
#include <cstdio>
#include <cmath>
#include <queue>
#include <list>
#include <map>
#include <set>
#include <stack>
#include <deque>
#include <vector>
#include <string>
#include <cstdlib>
#include <cassert>
#include <sstream>
#include <iterator>
#include <algorithm>

using namespace std;

long double facto (long double n) {
	long double i = 2,res = 1;
	for(;i <= n; ++i) {
		res *= i;
	}
	return res;
}

int main () {
	long double x;
	cin>>x;
	long double res = 1;
	long double i = 1;
	while(fabs(res-pow(M_El,x)) > 0.0001) {
		res += pow(x,i)/facto(i);
		++i;
	}
	cout << res << endl;
}
 

