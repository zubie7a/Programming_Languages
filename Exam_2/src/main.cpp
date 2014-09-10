#include "Lexic.h"
#include "Syntax.h"

int main () {
	string x;
	vector<string>z;
	inicializadorSets();
	cout << "\nIngresar Sentencia:\n";
	while(cin>>x) {
		z.push_back(x);
		while(cin.peek()!='\n'){
			cin>>x;
			z.push_back(x);
		}
		invocarAnalizadorLexico(z);
		invocarAnalizadorSintactico(z);
		z.clear();
		cout << "Desea seguir ingresando sentencias? (Y/N):\n";
		cin>>x;
		if(x=="N"){
			break;
		}
		else {
			cout << "\nIngresar Sentencia:\n\n";
		}

	}
}
