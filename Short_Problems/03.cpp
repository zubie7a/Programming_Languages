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

int main(){
	float ter;
	float ak;
	float ak2;
	cin >> ter;
	for(ter=1,ak=0;ak<1000;++ter){
		ak+= (ter*ter+1)/ter;
		if(ak<1000)
			ak2=ak;
	}
	cout << "El numero de terminos para que la sumatoria no exceda 1000 es " << ter-2 << " y la sumatoria es " << ak2 << endl;
}