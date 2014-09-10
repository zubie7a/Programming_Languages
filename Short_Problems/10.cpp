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

int main () {
	long double p,m,n,i;
	cout << " Ingrese el capital, el interes, la cantidad de año y las veces por año  n";
	cin >> p >> i >> n >> m;
	cout << pow(p*(1L+i/m),n*m) << endl;
}



