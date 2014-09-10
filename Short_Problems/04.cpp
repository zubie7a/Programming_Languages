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

float defact(float k){
	float decas=1;
	for(float i=2;i<=k;++i)
		decas*=i;
	return decas;
}

int	main(){
	float n;
	float j;
	cin >> n >> j;
	float flow;
	flow = defact(n)/(defact(j)*defact(n-j));
	cout << "El coeficiente binomial de n y j es " << flow << endl;
}
