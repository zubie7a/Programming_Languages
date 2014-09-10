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
	for(;i < n; ++i) {
		res *= i;
	}
	return res;
}

int main () {
	long double x;
	int n,i;
	cin>>x>>n;
	long double res = 1;
	x = fmod(x,(long double)2*M_PIl);
	int signo = (res > M_PI_2 && res < 3*M_PI_2)? -1:1;
	x = fmod(x,(long double)M_PIl);
	for (i = 1; i < n; ++i) {
		res += pow((long double)-1, (long double) (i))*pow(x,(long double)(2*i))/facto((long double)(2*i));
	}
	cout << signo*res << endl;
}
