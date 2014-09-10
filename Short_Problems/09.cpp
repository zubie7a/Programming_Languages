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
	float v0;
	float t;
	float ac;
	cout << "Ingrese la velocidad inicial: ";
	cin >> v0;
	cout << "Ingrese la aceleracion: ";
	cin >> ac;
	cout << "Ingrese el tiempo del recorrido: ";
	cin >> t;
	cout << "La distancia total recorrida es: " << v0*t + ac*t*t/2 << endl;
	cout << "Y la velocidad final es: " << sqrt(v0*v0-2*ac*t);
}



