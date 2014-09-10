#pragma once
#include "DesarrolladorMatematico.h"

bool minmat(vector <string> z){
	if(z.size()<4 || (z.size()%2)){
		return false;
	}
	if(!inicial(z[0]) || !asignacion(z[z.size()-2]) || !variable(z[z.size()-1])){
		return false;
	}
	z.erase(z.begin(),z.begin()+1);
	z.pop_back();
	z.pop_back();
	return expresion(z);
}

void invocarAnalizadorSintactico(vector <string> z){
	string x;
	cout << "\n\nAnalizador Sintactico: Sentencia ";
	bool invalido;
	if(invalido=!minmat(z)){
		cout<<"in";
	}
	cout<<"valida\n\n"<<endl;
	if(!invalido){
		cout << "Valor final de "<< z[z.size()-1] << ": ";
		z.erase(z.begin(),z.begin()+1);
		z.pop_back();
		z.pop_back();
		cout << valorFinal(z) << endl;
	}
	else {
		cout << "Sentencia Errada\n"; 
	}
	
}
