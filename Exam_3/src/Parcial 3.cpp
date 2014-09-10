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

bool myus(char x){ //retorna si el caracter es mayuscula o dominante
      return (x>=65 && x<=90);       
}

bool mnus(char y){ //retorna si el caracter es minuscula o recesivo
      return (y>=97 && y<=122);
}

char compara(char m, char p){ //retorna el dominante
      if(m<p){ //en ASCII el dominante es menor que el recesivo por el codigo de las mayusculas
          return m;
      }
      else{
          return p;
      }
}

int main(){
 
    string madre;
    string padre;
    string hija;
    string hijo;
    char M;
    char P;
    
    cin >> madre >> padre;
    hija = hijo = ""; //inicializa en vacio
    
    for(int z=0; z<madre.length();++z){ //hasta la longitud de madre porque miden igual
            M = madre[z];
            P = padre[z];
            if((myus(M) && mnus(P)) || (myus(P) && mnus(M))){ //al menos 1 recesivo y 1 dominante
                 hija += compara(M,P); 
                 hijo += compara(M,P);
            }
            else{ //si llega al else es que ambos son dominantes o ambos recesivos
                 hija += M; //de esta manera se le da a la hija el de la madre
                 hijo += P; //y al hijo el del padre
            }
    }
    cout << hija << endl << hijo << endl;
    system("pause");
}
