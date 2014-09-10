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
#define PI 3.141592

using namespace std;

int main () {
	long double pi = 0.0;
	long double i = 1;
	while(fabs(sqrtl(pi)/(long double)2 - PI) > 0.0001) {
		pi += (long double)24/(i*i);
		++i;
	}
	cout<<sqrtl(pi)/(long double)2<<endl;
}
