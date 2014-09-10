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

float hecho(float k){
	float ret=1;
	for(float i=2;i<=k;++i)
		ret*=i;
	return ret;
}

int main(){
	float m;
	float n;
	cin >> m >> n;
	float wolf;
	flow = hecho(m)/(hecho(n)*hecho(m-n));
	cout << "El coeficiente binomial de m y n es "<<wolf<<endl;
}


