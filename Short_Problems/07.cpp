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
	float p;
	float N;
	cin >> p >> N;
	for(int K=0;K<=N;++K){
		cout << "Para K=" << K;
		cout << " la P(K) es " << pow(p,K)*pow(1-p,N-K)*defact(N)/(defact(K)*defact(N-K)) << endl;
	}
}

