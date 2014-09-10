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

long long facto (long long N) {
	long long i = 1;
	for (int j = 2; j <= N; ++j) {
		i *= j;
	}
	return i;
}

long double seno (long double x, long double N) {
	long double res = 0;
	for (long double n = 1; n <= N; ++n) {
		res +=	pow((long double)-1, (long double)(n+1))*(pow(x,2*n-1)/facto(2*n-1));
	}
	return res;
}

int main () {
long double ang;
long  N;
	cin>>ang>>N;
	int signo = -1;
	if (int(ang/3.1415926L)%2) {
		signo = 1;
	} 
	ang = fmod(ang,3.1415926L);
	cout << signo*seno(ang,N) << endl;
}
