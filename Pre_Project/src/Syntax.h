#pragma once
#include "Basics.h"

bool asker(vector <string> z,bool diverse,bool reverse,int cal,int pre){
	if(!inicial(z[0]) || !fin(z[z.size()-1])){
		return false;
	}
	if(z[0]=="Que" && z[2]=="venden?"){
		for(int m=0;m<z[1].length();++m){
			if(z[1][m]==','){
				z[1][m] = ' ';
			}
		}
		parteComida(z[1]);
		return true;
	}
	if(z[0]=="Generar" && z.size()-7<=1){
		if(z.size()==8){
			for(int m=0;m<z[5].length();++m){
				if(z[5][m]==','){
					z[5][m] = ' ';
				}
			}
			generador(z[5],true,diverse,reverse,cal,pre);
		}
		else {			
			generador(z[5],false,true,true,cal,pre);
		}
		return true;
	}
	return false;
}

void invocarAnalizadorSintactico(vector <string> z,bool diverse,bool reverse,int cal,int pre){
	if(!asker(z,diverse,reverse,cal,pre)){
		cout << "Por favor sea mas claro en su proximo pedido, no le entendemos" << endl; 
	}
		
}
